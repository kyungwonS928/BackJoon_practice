#include<iostream>
#include<string>
using namespace std;

int main() {
    int N;
    int B = 0;
    string result;
    cin >> N;
    B = N / 4;
    for(int i = 0; i<B; i++) {
        result += "long ";
    }
    result += "int";
    cout << result;
    return 0;
}