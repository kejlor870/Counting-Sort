<?php

function countingSort($numbers){
    if(empty($numbers)) return [[], []];

    // Get the biggest number from array
    $maxNumber = (int) max($numbers);

    // Fill counting array with 0s
    $countArr = array_fill(0, $maxNumber + 1, 0);

    // Count numbers occurance
    foreach($numbers as $number) $countArr[$number]++;

    // Sorting without duplications
    //  - array_filter rejects 0s and array_keys returns indexes
    $sortedWODuplications = array_keys(array_filter($countArr));

    // Sort
    $sortedArr = [];

    for($i = 0; $i < $maxNumber + 1; $i++){
        while($countArr[$i] > 0){
            $sortedArr[] = $i;
            $countArr[$i]--;
        }
    }

    
    return [$sortedArr, $sortedWODuplications];
}