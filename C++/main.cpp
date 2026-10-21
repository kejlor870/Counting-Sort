#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>
#include <string>
using namespace std;

vector<int> CountingSort(vector<int> numbers){
    if(numbers.empty()){
        return {};
    }
    
    // Search for the biggest number, max_element returns reference in memory to that number
    //  - * pulls out acctual number from that reference
    int maxNumber = *max_element(numbers.begin(), numbers.end());
    
    // Creating new vector with 0s
    vector<int> countArr(maxNumber + 1, 0);
    
    // Filling countArr with numbers of occurrences
    for(int index : numbers) countArr[index]++;
    
    // Sorting
    vector<int> sortedArr;
    
    for(int i=0; i < maxNumber + 1; i++){
        while(countArr[i] > 0){
            sortedArr.push_back(i);
            countArr[i]--;
        }
    }
    
    return sortedArr;
}

int main()
{
    string line;
    vector<int> numbers;
    
    cout << "-- Counting Sort --" << endl;
    
    // Get user provided numbers
    cout << "Podaj liczby oddzielone spacjami: ";
    getline(cin, line);
    
    // Insert numbers to array
    stringstream ss(line);
    int number;
    while(!ss.eof()){   // while ss doesn't reach the end of string
        if(ss >> number){   // converting to int
            if(number >= 0) numbers.push_back(number);
        }else{
            // Validate letters
            ss.clear();
            ss.get();
        }
    }
    
    // Empty string error message and program interruption
    if(numbers.empty()){
        cout << "Blad: Nie podano poprawnych liczb." << endl;
        return 0;
    }
    
    // Display saved numbers
    cout << "Podane liczby: ";
    for(int number : numbers) cout << number << " ";
    
    // Sorting
    vector<int> sortedArray = CountingSort(numbers);
    
    // Display sorted
    cout << "\nPosortowane liczby: \n\t";
    for(int number : sortedArray) cout << number << " ";
    

    return 0;
}