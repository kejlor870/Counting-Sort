<?php

function countingSort($numbers){
    if(empty($numbers)) return [[], []];

    // Get the biggest and smallest numbers from array
    $minNumber = (int) min($numbers);
    $maxNumber = (int) max($numbers);

    // Fill counting array with 0s
    $countArr = array_fill(0, $maxNumber - $minNumber + 1, 0);

    // Count numbers occurance
    foreach($numbers as $number) $countArr[$number - $minNumber]++;

    // Sorting without duplications
    //  - array_filter rejects 0s and array_keys returns indexes
    //  array_map is filling array with index + minNumber which is responsible for given even negative number
    $sortedWODuplications = array_map(
        function($index) use ($minNumber){
            return $index + $minNumber;
        }, 
        array_keys(array_filter($countArr))
    );

    // Sort
    $sortedArr = [];

    for($i = 0; $i < $maxNumber - $minNumber + 1; $i++){
        while($countArr[$i] > 0){
            $sortedArr[] = $i + $minNumber;
            $countArr[$i]--;
        }
    }

    
    return [$sortedArr, $sortedWODuplications];
}