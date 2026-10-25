<?php
use PHPUnit\Framework\TestCase;

require_once __DIR__ . '/countingSort.php';

class CountingSortTests extends TestCase {
    public function testSortPositiveNumbers(){
        $input = [3, 4, 2, 1, 7, 4, 10, 8];

        list($sorted, $unique) = countingSort($input);

        $expectedSorted = [1, 2, 3, 4, 4, 7, 8, 10];
        $expectedUnique = [1, 2, 3, 4, 7, 8, 10];

        $this->assertEquals($expectedSorted, $sorted, 'Tablica z duplikatami nie została posortowana poprawnie!');
        $this->assertEquals($expectedUnique, $unique, 'Tablica unikalnych wartości jest błędna!');
    }

    public function testSortingNegativeAndPositiveNumbers(){
        $input = [2, 1, -2, 4, -5, 2];

        list($sorted, $unique) = countingSort($input);

        $expectedSorted = [-5, -2, 1, 2, 2, 4];
        $expectedUnique = [-5, -2, 1, 2, 4];

        $this->assertEquals($expectedSorted, $sorted, 'Tablica z duplikatami nie została posortowana poprawnie!');
        $this->assertEquals($expectedUnique, $unique, 'Tablica unikalnych wartości jest błędna!');
    }

    public function testEmptyArraySupport(){
        $input = [];

        list($sorted, $unique) = countingSort($input);

        $expectedSorted = [];
        $expectedUnique = [];
        
        $this->assertEquals($expectedSorted, $sorted);
        $this->assertEquals($expectedUnique, $unique);
    }

    public function testArrayWithOnlyZeros(){
        $input = [0, 0, 0];

        list($sorted, $unique) = countingSort($input);

        $expectedSorted = [0, 0, 0];
        $expectedUnique = [0];

        $this->assertEquals($expectedSorted, $sorted);
        $this->assertEquals($expectedUnique, $unique);
    }

    public function testSupportDuplicatedNegativeNumbers(){
        $input = [-5, -5, -5, -1, -3];

        list($sorted, $unique) = countingSort($input);

        $expectedSorted = [-5, -5, -5, -3, -1];
        $expectedUnique = [-5, -3, -1];

        $this->assertEquals($expectedSorted, $sorted);
        $this->assertEquals($expectedUnique, $unique);
    }

}
