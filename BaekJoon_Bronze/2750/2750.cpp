#include<iostream>
#include<algorithm>
using namespace std;


int main() {
    
    int N;
    cin >> N;
    int temp = 0;

    int* num = new int[N];

    for(int i = 0; i<N; i++) {
        cin >> num[i];
    }

    sort(num[0], num[0] + N);

    for(int i = 0; i < N; i++) {
        cout << num[i] << endl;
    } 
    
    return 0;
}