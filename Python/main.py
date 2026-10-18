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

    # Saving sorted numbers without duplications in list
    sorted_wo_duplications = []

    for index in range(max_number + 1):
        if count_arr[index] != 0:
            sorted_wo_duplications.append(index)

    # Saving sorted numbers in list ! it changes provided array
    sorted_arr = []

    for index in range(max_number + 1):
        while count_arr[index] > 0:
            sorted_arr.append(index)
            count_arr[index] -= 1

    return {
        "sorted_arr": sorted_arr,
        "sorted_wo_duplications": sorted_wo_duplications
    }

# --- MAIN ---
if __name__ == '__main__':

    numbers = [1, 3, 2, 3, 4, 7, 2, 7, 12, 2, 9, 6, 7]

    print(f"Podane liczby: {', '.join(str(number) for number in numbers)}")

    result = counting_sort(numbers.copy())

    if result is not None:
        # Unpack data from result
        numbers_sorted, numbers_sorted_wo_duplications = result.values()

        print(f'Posortowana tablica:\n\t', numbers_sorted)
        print(f'Posortowana tablica \033[1mbez dubplikatow\033[0m:\n\t', numbers_sorted_wo_duplications)
