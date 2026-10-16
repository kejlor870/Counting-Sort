let numbers = [1, 3, 4, 2, 8, 2, 9, 1, 18, 4, 6, 2, 5];

// Function: CountingSort
//  Returns object with 2 arrays, SortedArray and SortedWithoutDuplications.
//  You can choose if you want only one array using CountingSort(numbersArray).nameOfWantedArray
function CountingSort(array) {
    if(array.length === 0) return array;

    // Find the biggest number
    const maxNumber = Math.max(...array);

    // Create counting array filled with zeros for every number: 0 -> maxNumber
    let countArr = new Array(maxNumber + 1).fill(0);

    // Filling countArr on index from numbers array value
        // for(let i = 0; i < maxNumber + 1; i++) countArr[numbers[i]]++;
    for(let number of array) countArr[number]++;

    // Filling sortedArray with value if countArr value isn't 0 else insert null
    //  after filling filter method insert only values to array without nulls
        // let simpleSortedArr = new Array();
        // for(let i = 0; i < countArr.length; i++) countArr[i] != 0 ? simpleSortedArr.push(i) : null;
    let simpleSortedArr = countArr.map((value, index) => value != 0 ? index : null).filter(value => value != null);

    // Filling sortedArray with sorted values
    let sortedArray = new Array();

    for(let i = 0; i < countArr.length; i++){
        while(countArr[i] > 0){
            sortedArray.push(i);
            countArr[i]--;
        }
    }
    
    return {
        SortedArray: sortedArray,
        SortedWithoutDuplications: simpleSortedArr
    };
}

console.log(CountingSort(numbers));