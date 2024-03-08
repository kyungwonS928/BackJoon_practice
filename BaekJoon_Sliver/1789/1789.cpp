#include<iostream>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    long long S;
    cin >> S;

    
    long long k = 1;
    while (k * (k + 1) <= 2 * S) {
        k++;
    }

    cout << k-1;
    
    return 0;

}