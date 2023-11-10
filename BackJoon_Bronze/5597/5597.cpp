#include<iostream>
using namespace std;

int main() {
    int array[30] = {0,};
    int N;

    for(int i = 0; i<28; i++) {
        cin >> N;
        array[N-1] = 1;
    }

    for(int i = 0; i<30; i++) {
        if(array[i] == 0) {
            cout<< i+1 << '\n';
        }
    }

    return 0;

}