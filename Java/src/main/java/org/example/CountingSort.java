package org.example;

import java.util.ArrayList;

// Return record
record CountingSortResult(ArrayList<Integer> sortedArray, ArrayList<Integer> sortedWithoutDuplications) {};

public class CountingSort {

    public static CountingSortResult sort(ArrayList<Integer> array){
        if(array == null || array.isEmpty()){
            System.out.println("\033[31mNie podano poprawnych liczb.\033[0m");

            return null;
        }

        // Find the biggest number
        int maxNumber = array.getFirst();   // Get first as the hint
        for(int number : array) if(number > maxNumber) maxNumber = number;

        // Create empty array to count with indexes
        int[] countArr = new int[maxNumber + 1];

        // Filling countArr with +1 on indexes from given array
        for (int number : array) countArr[number]++;

        // Display sorted array without duplications
        ArrayList<Integer> sortedWithoutDuplications = new ArrayList<>();

        for(int i=0; i < countArr.length; i++){
            if(countArr[i] != 0) sortedWithoutDuplications.add(i);
        }

        // Display sorted array
        ArrayList<Integer> sorted = new ArrayList<>(array.size());

        for(int i=0; i < countArr.length; i++){
            while (countArr[i] != 0){
                sorted.add(i);
                countArr[i]--;
            }
        }

        return new CountingSortResult(sorted, sortedWithoutDuplications);
    }
}
