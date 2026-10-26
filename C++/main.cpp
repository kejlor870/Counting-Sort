#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>
#include <string>
#include <utility>
using namespace std;

pair<vector<int>, vector<int>> CountingSort(vector<int> numbers){
    if(numbers.empty()) return {{}, {}};
    
    // Search for the biggest number, max_element returns reference in memory to that number
    //  - * pulls out acctual number from that reference
    int maxNumber = *max_element(numbers.begin(), numbers.end());
    int minNumber = *min_element(numbers.begin(), numbers.end());
    
    // Creating new vector with 0s
    vector<int> countArr(maxNumber - minNumber + 1, 0);
    
    // Filling countArr with numbers of occurrences
    for(int index : numbers) countArr[index - minNumber]++;
    
    // Sorting /without duplications
    vector<int> sortedWODuplications;
    vector<int> sortedArr;
    
    for(int i=0; i < maxNumber - minNumber + 1; i++){
        if(countArr[i] > 0) sortedWODuplications.push_back(i + minNumber);
        
        while(countArr[i] > 0){
            sortedArr.push_back(i + minNumber);
            countArr[i]--;
        }
    }
    
    return {sortedArr, sortedWODuplications};
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
            numbers.push_back(number);
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
    auto [sortedArray, sortedWODupl] = CountingSort(numbers);
    
    // Display sorted
    cout << "\nPosortowane liczby: \n\t";
    for(int number : sortedArray) cout << number << " ";
    
    cout << "\nPosortowane liczby bez duplikatow: \n\t";
    for(int number : sortedWODupl) cout << number << " ";
    

    return 0;
}