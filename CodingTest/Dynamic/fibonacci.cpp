#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arr[100] ={0,};

int fibo(int x) {
    if(x ==1 || x == 2) {
        return 1;
    }
    if(arr[x] != 0) {
        return arr[x];
    }
    arr[x] = fibo(x-1) + fibo(x-1);
    return arr[x];

}

int fibo2(int x) {
    arr[1] =1;
    arr[2] =1;
    for(int i =3; i<100; i++) {
        arr[i] =  arr[i-1] + arr[i-2];
    }

    return arr[x];
}
int main() {
}
