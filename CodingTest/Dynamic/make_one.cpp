#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arr[30001] ={0,};

int makeOne(int x) {
    
    if(arr[x] !=0) {
        return arr[x];
    }

    for(int i =2; i<x+1; i++) {
        //현재의 수에서 1을 빼는 경우
        arr[i] = arr[i-1] + 1;

        //현재의 수가 2로 나누어 떨어지는 경우
        if(i%2== 0) arr[i] = min(arr[i], arr[i/2] + 1);
        if(i%3 ==0) arr[i] = min(arr[i], arr[i/3] +1);
        if(i%5 ==0) arr[i] = min(arr[i], arr[i/5] +1);

    


    }
    return arr[x];

}


int main() {


}
