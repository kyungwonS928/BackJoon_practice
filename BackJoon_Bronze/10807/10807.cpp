#include<iostream>
#include<string>
using namespace std;

int main() {
    int N, H;
    int total = 0;
    cin >> N;

    int *array = new int[N];

    for(int i = 0; i<N; i++) {
        int t = 0;
        cin >> t;
        array[i] = t;
    }
    cin >> H;

    for(int i = 0; i<N; i++) {
        if(array[i] == H) {
            total++;
        }
    }
    
    cout << total;

    delete[] array;

    return 0;

}