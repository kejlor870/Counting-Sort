<?php
require_once 'countingSort.php';

// Get numbers from user
$userInput = readline("Podaj liczby oddzielone spacjami: ");

// Create array from user input divided by ' ' - space and filter from double space
$userInputElements = array_filter(explode(' ', trim($userInput)), 'strlen');

// Validate letters and only keep numbers
$userInputNumbers = array_filter($userInputElements, 'is_numeric');

// Convert userInputNumbers to int type
$numbers = array_map('intval', $userInputNumbers);

echo "Podane liczby: " . implode(' ', $numbers) . "\n";

// Validate for user empty array
if(empty($numbers)){
    echo "Blad: Przekazano pusta tablice liczb!";
    exit;
}

// Sorting function call and destructurisation
[$sorted, $sortedWODupl] = countingSort($numbers);

echo "Posortowana tablica: \n\t" . implode(' ', $sorted) . "\n";
echo "Posortowana tablica bez duplikatow: \n\t" . implode(' ', $sortedWODupl) . "\n";
