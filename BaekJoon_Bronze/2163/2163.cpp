#include<iostream>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int  N, M;
    cin >> N >> M;

    // if(N==1 && M==1) {
    //     cout << 0;
    // } else if (N!=1 && M == 1) {

    //     cout << N-1;
    // } else if (N == 1 && M != 1) {
        
    //     cout << M-1;
    // } else {
        
    //     cout << N + N * (M-1);
    // }

    cout << N * M -1;
    return 0;

}