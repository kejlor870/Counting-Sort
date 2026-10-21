#include <iostream>
#include <vector>
#include <algorithm>
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
    cout << "-- Counting Sort --" << endl;
    
    vector<int> numbers = {10, 16, 3, 4, 16, 2, 3, 11, 24, 2, 5, 1, 16};
    
    cout << "Podane liczby: ";
    for(int number : numbers) cout << number << " ";
    
    // Sorting
    vector<int> sortedArray = CountingSort(numbers);
    
    // Display sorted
    cout << "\nPosortowane liczby: \n\t";
    for(int number : sortedArray) cout << number << " ";
    

    return 0;
}