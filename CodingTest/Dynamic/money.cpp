#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arr[10001] ={10001,};
//배열의 크기는 m+1 값

int money(int n, int m) {

    arr[0] = 0;
    for(int i = 1; i< n; i++) {
        for(int j = arr[i]; j<m+1; j++) {
            if(arr[j-arr[i]] != 10001) {
                arr[j] = min(arr[j], arr[j-arr[i]] +1);
            }
        }
    }
    return arr[m];

}


int main() {

}
