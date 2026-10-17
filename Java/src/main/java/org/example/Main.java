package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Example numbers
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 4, 2, 3, 4, 12, 1, 8, 2, 7, 5, 2, 6, 18, 11, 12));

        System.out.println("\t\033[1;30;44mCounting sort!\033[0m");
        System.out.println("\033[32mPodane liczby:\033[0m\n\t" + numbers);

        // Sorting func call and result fetch
        CountingSortResult result = CountingSort.sort(new ArrayList<>(numbers));

        if(result != null) {
            System.out.println("Posortowana tablica:\n\t" + result.sortedArray());
            System.out.println("Posortowana tablica \033[1mbez duplikatow\033[0m:\n\t" + result.sortedWithoutDuplications());
        }

    }
}