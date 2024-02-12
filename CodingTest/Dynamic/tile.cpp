#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arr[1001] ={0,};

int ant(int n, int* num) {
    
    arr[1] =1;
    arr[2] = 3;
    for(int i =3; i<=n; i++) {
        arr[i] = (arr[i-1] + 2 * arr[i-2]) % 796796;
    }
    
    return arr[n-1];

}


int main() {

}
