#include<iostream>
#include<string>
using namespace std;

int getSumOfDigits(int n) {
    int sum = 0;
    while (n > 0) {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}

int main() {
    int N;
    cin >> N;
    for(int i = 1; i<N; i++) {
        int constructor = i + getSumOfDigits(i);
        if(N == constructor) {
            cout << i;
            return 0;
        }
    }

    cout << 0;
    return 0;
}