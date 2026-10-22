<?php
require_once 'countingSort.php';

$numbers = [1, 4, 2, 10, 1, 18, 6, 3, 8, 2, 7, 24, 1, 6, 10];

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
