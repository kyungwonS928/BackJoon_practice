#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arr[101] ={0,};

int ant(int n, int* num) {
    
    arr[0] = num[0];
    arr[1] = max(num[0], num[1]);
    for(int i = 2; i<n; i++) {
        arr[i] = max(arr[i-1], arr[i-2] + arr[i]);
    }

    
    return arr[n-1];

}


int main() {

}
