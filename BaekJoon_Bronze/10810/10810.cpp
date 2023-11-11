#include<iostream>
using namespace std;

int main() {
    int N, M;
    int i, j, k;


    cin >> N >> M;

    int *array = new int[N];


    for(int t = 0; i<N; i++) {
        array[t] = 0;
    }

    for(int t = 0; t<M; t++) {
        cin >> i >> j >> k;
        for (int m = i-1; m<j; m++) {
            array[m] = k;
        }
    }
    
    for(int t = 0; t<N; t++) {
        cout << array[t] <<' ';
        
    }

    delete[] array;

    return 0;

}