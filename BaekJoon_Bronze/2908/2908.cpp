#include<iostream>
#include<string>
using namespace std;

int main() {
    string N1, N2;
    string n1, n2 ="";

    cin >> N1 >> N2;

    // 첫번째 풀이
    // if(N1[2] > N2[2]) {
    //     cout << N1[2] <<N1[1] << N1[0];
    // } else if( N1[2] == N2[2]) {
    //     if (N1[1] > N2[1]) {
    //     cout << N1[2] <<N1[1] << N1[0];
    //     } else if(N2[1] == N2[1]) {
    //         if (N1[0] > N2[0]) {
    //     cout << N1[2] <<N1[1] << N1[0];
    //         } else 
    //         cout << N2[2]<<N2[1]<<N2[0];
    //     } else 
    //     cout << N2[2]<<N2[1]<<N2[0];
    // } else 
    // cout << N2[2]<<N2[1]<<N2[0];

    for(int i = 2; i>=0; i--) {
        n1 += N1[i];
        n2 += N2[i];
    }

    cout << max(n1, n2);

}