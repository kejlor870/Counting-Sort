from main import counting_sort

# AAA type test (Arrange-Act-Assert)
def test_counting_sort_positive_numbers():
    test_array =  [5, 2, 8, 1]  # Arrange

    result = counting_sort(test_array)  # Act

    # Assert
    assert result["sorted_arr"] == [1, 2, 5, 8]

# Shorter but not like AAA (Arrange-Act-Assert)
def test_counting_sort_negative_postive_numbers():
    assert counting_sort([4, -2, 7, -5, 0, 2, -2])["sorted_arr"] == [-5, -2, -2, 0, 2, 4, 7]


def test_counting_sort_wo_duplicates():
    assert counting_sort([4, -2, 7, -5, 0, 2, -2])["sorted_wo_duplications"] == [-5, -2, 0, 2, 4, 7]

def test_counting_sort_empty_array():
    test_array = []

    result = counting_sort(test_array)

    assert result is None

def test_counting_sort_only_zeros():
    assert counting_sort([0, 0, 0])["sorted_arr"] == [0, 0, 0]

def test_counting_sort_negative_duplicated():
    assert counting_sort([-3, -3, -1, -3])["sorted_arr"] == [-3, -3, -3, -1]
    assert counting_sort([-3, -3, -1, -3])["sorted_wo_duplications"] == [-3, -1]
