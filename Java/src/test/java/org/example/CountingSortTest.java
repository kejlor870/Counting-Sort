package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CountingSortTest {

    @Test
    void shouldSortPositiveNumbers(){
        var input = new ArrayList<>(
                List.of(5, 2, 9, 2, 7, 5, 1)
        );

        CountingSortResult result = CountingSort.sort(input);

        assertEquals(
                List.of(1, 2, 2, 5, 5, 7, 9),
                result.sortedArray()
        );

        assertEquals(
                List.of(1, 2, 5, 7, 9),
                result.sortedWithoutDuplications()
        );
    }

    @Test
    void shouldSortNegativeNumbers() {
        var input = new ArrayList<>(
                List.of(-5, -2, -9, -2, -7)
        );

        CountingSortResult result = CountingSort.sort(input);

        assertEquals(
                List.of(-9, -7, -5, -2, -2),
                result.sortedArray()
        );

        assertEquals(
                List.of(-9, -7, -5, -2),
                result.sortedWithoutDuplications()
        );
    }

    @Test
    void shouldSortMixedNumbers() {
        var input = new ArrayList<>(
                List.of(5, -2, 9, 2, -7, 5, 0, -2, 1)
        );

        CountingSortResult result = CountingSort.sort(input);

        assertEquals(
                List.of(-7, -2, -2, 0, 1, 2, 5, 5, 9),
                result.sortedArray()
        );

        assertEquals(
                List.of(-7, -2, 0, 1, 2, 5, 9),
                result.sortedWithoutDuplications()
        );
    }

    @Test
    void shouldHandleDuplicates() {
        var input = new ArrayList<>(
                List.of(3, 3, 3, -1, -1, 0, 0)
        );

        CountingSortResult result = CountingSort.sort(input);

        assertEquals(
                List.of(-1, -1, 0, 0, 3, 3, 3),
                result.sortedArray()
        );

        assertEquals(
                List.of(-1, 0, 3),
                result.sortedWithoutDuplications()
        );
    }

    @Test
    void shouldHandleSingleElement() {
        var input = new ArrayList<>(List.of(-42));

        CountingSortResult result = CountingSort.sort(input);

        assertEquals(List.of(-42), result.sortedArray());
        assertEquals(List.of(-42), result.sortedWithoutDuplications());
    }

    @Test
    void shouldHandleAlreadySortedNumbers() {
        var input = new ArrayList<>(
                List.of(-5, -2, 0, 3, 8)
        );

        CountingSortResult result = CountingSort.sort(input);

        assertEquals(
                List.of(-5, -2, 0, 3, 8),
                result.sortedArray()
        );
    }

    @Test
    void shouldReturnNullForEmptyArray() {
        var input = new ArrayList<Integer>();

        CountingSortResult result = CountingSort.sort(input);

        assertNull(result);
    }

    @Test
    void shouldReturnNullForNullArray() {
        CountingSortResult result = CountingSort.sort(null);

        assertNull(result);
    }
}
