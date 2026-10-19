# This is a simple Python Counting Sort script.

def counting_sort(array):
    if not array:
        print("\033[31mNie podano poprawnych liczb.\033[0m")
        return

    # Get max number
    max_number = max(array)

    # Create list filled by 0 with size of maxNumber
    count_arr = [0] * (max_number + 1)

    # Counting how many times each number appear in array, number = index
    for number in array:
        count_arr[number] += 1

    # Saving sorted numbers in lists
    sorted_wo_duplications = []
    sorted_arr = []

    for index in range(max_number + 1):
        if count_arr[index] > 0:
            sorted_wo_duplications.append(index)            # saving sorted numbers without duplications
            sorted_arr.extend([index] * count_arr[index])   # adding number by multiple of count_arr[index]


    return {
        "sorted_arr": sorted_arr,
        "sorted_wo_duplications": sorted_wo_duplications
    }

# --- MAIN ---
if __name__ == '__main__':

    # Get numbers from user and split by space
    userInput = input("Podaj liczby rozdzielone spacja: ").split()

    # Convert string element to int if is digit, letters are ignored
    user_numbers = [int(element) for element in userInput if element.isdigit()]

    # Save result in variable after function call
    result = counting_sort(user_numbers.copy())

    if result is not None:
        print(f"Podane liczby: {', '.join(str(number) for number in user_numbers)}")

        # Unpack data from result
        numbers_sorted, numbers_sorted_wo_duplications = result.values()

        print(f'Posortowana tablica:\n\t', numbers_sorted)
        print(f'Posortowana tablica \033[1mbez duplikatow\033[0m:\n\t', numbers_sorted_wo_duplications)
