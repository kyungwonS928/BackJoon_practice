#include<iostream>
#include<algorithm>
using namespace std;


int main() {
    int N, K;
    cin >> N >> K;
    int count = 0;

    while(N!=1) {
        if(N%K ==0) {
            N /= K;
        } else {
            N -= 1;
        }
        count++;
    }
    cout << count;
    return 0;
}