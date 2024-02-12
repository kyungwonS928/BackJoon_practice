#include<iostream>

using namespace std;

int factorial(int x) {
    if(x <= 1) return 1;
    return x* factorial(x-1);
    
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    
    int result = factorial(N);

    cout << result;

    return 0;

}