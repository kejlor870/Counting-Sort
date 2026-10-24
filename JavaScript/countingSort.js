const readline = require('node:readline/promises');
const { stdin: input, stdout: output } = require('node:process');

// Function: CountingSort
//  Returns object with 2 arrays, SortedArray and SortedWithoutDuplications.
//  You can choose if you want only one array using CountingSort(numbersArray).nameOfWantedArray
function CountingSort(array) {
    if(array.length === 0) return array;

    // Find the biggest and smaller number
    const minNumber = Math.min(...array);
    const maxNumber = Math.max(...array);

    // Create counting array filled with zeros for every number: 0 -> maxNumber - minNumber
    let countArr = new Array(maxNumber - minNumber + 1).fill(0);

    // Filling countArr on index from numbers array value
    for(let number of array) countArr[number - minNumber]++;

    // Filling sortedArray with value if countArr value isn't 0 else insert null
    //  after filling filter method insert only values to array without nulls
        // let simpleSortedArr = new Array();
        // for(let i = 0; i < countArr.length; i++) countArr[i] != 0 ? simpleSortedArr.push(i + minNumber) : null;
    let simpleSortedArr = countArr.map((value, index) => value != 0 ? (index + minNumber) : null).filter(value => value != null);

    // Filling sortedArray with sorted values
    let sortedArray = new Array();

    for(let i = 0; i < countArr.length; i++){
        while(countArr[i] > 0){
            sortedArray.push(i + minNumber);
            countArr[i]--;
        }
    }
    
    return {
        SortedArray: sortedArray,
        SortedWithoutDuplications: simpleSortedArr
    };
}

// MAIN FUNCTION
async function main() {
    const rl = readline.createInterface({ input, output });

    // Get user input
    const userAnswer = await rl.question("Podaj liczby do posortowania (rozdzielone spacjami): ");

    // Convert user input from text to array
    const numbers = userAnswer
        .trim()                             // clear from white spaces (start and end)
        .split(/\s+/)                       // split with space
        .filter(value => value !== "")      // insert if is not a "" - empty input
        .map(Number)                        // convert to Number from text
        .filter(value => !isNaN(value))     // filter all non number, leave only numbers
    ;

    // Validate empty input
    if(numbers.length === 0){
        console.log("\x1b[31m Nie podano poprawnych liczb.\x1b[0m");

    } else {
        // Display user provided numbers
        console.log("\t| Podane przez \x1b[1;32mciebie\x1b[0m liczby: ", ...numbers);

        // Make line with minuses to separate content
        console.log("\t|" + "-".repeat(30) + "-".repeat(userAnswer.trim().length))

        // Sorting function call and save returnd Object to variable
        const CountingSortReturn = await CountingSort(numbers);

        // Display sorted arrays
        console.log("\t| Posortowane liczby:", ...CountingSortReturn.SortedArray)
        console.log("\t| Posortowane liczby bez duplikatów:", ...CountingSortReturn.SortedWithoutDuplications)
    }
    
    rl.close()
}

module.exports = CountingSort;
if(require.main === module) main();