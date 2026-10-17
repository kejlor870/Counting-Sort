package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("\t\033[1;30;44mCounting sort!\033[0m");

        // Get numbers from user via console
        System.out.println("Podaj liczby oddzielone spacjami: ");
        String userinput = scanner.nextLine();
        scanner.close();

        // Validate user input
        if(userinput == null || userinput.trim().isEmpty()){
            System.out.println("\033[31mNie wpisano żadnych danych.\033[0m");

        } else {
            String[] elements = userinput.trim().split("\\s+");

            // Convering userInput elements to int type
            for(String element : elements){
                try{
                    int number = Integer.parseInt(element);
                    numbers.add(number);
                } catch (NumberFormatException e){
                    // If element can't be converted to number type, ex. letters
                    System.out.println("\033[33m# Pominieto '" + element + "', poniewaz nie jest liczba.\033[0m");
                }
            }
        }

        System.out.println("\033[32mPodane liczby:\033[0m\n\t" + numbers);

        // Sorting func call and result fetch
        CountingSortResult result = CountingSort.sort(new ArrayList<>(numbers));

        if(result != null) {
            System.out.println("Posortowana tablica:\n\t" + result.sortedArray());
            System.out.println("Posortowana tablica \033[1mbez duplikatow\033[0m:\n\t" + result.sortedWithoutDuplications());
        }

    }
}