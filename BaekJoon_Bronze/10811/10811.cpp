#include<iostream>
using namespace std;

int main() {
    int N, M;
    int i, j;
    int temp=0;

    cin >> N >> M;

    int *array = new int[N];


    for(int t = 0; t<N; t++) {
        array[t] = t+1;
    }

    for(int t = 0; t<M; t++) {
        cin >> i >> j;
        for(int m=0; m < (j-i+1)/2;m++) {
            temp = array[i-1+m];
            array[i-1+m]= array[j-1-m];
            array[j-1-m] = temp;
        }
    }
    
    for(int t = 0; t<N; t++) {
        cout << array[t] <<' ';
        
    }

    delete[] array;

    return 0;

}