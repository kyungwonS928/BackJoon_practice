#include<iostream>
#include<string>
using namespace std;

int main() {
    string Dial[8] = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    int time = 0;
    string alphabet;

    cin >> alphabet;
    
    for(int m = 0; m< alphabet.length(); m++){
        for(int i = 0; i < 8; i++) {
            int index = Dial[i].find(alphabet[m]);
            if (index != string::npos) {
                time = time + i + 3;
    
            }
        }
    }
    cout << time;
}