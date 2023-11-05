#include <iostream>
using namespace std;

int main() { 
    int H, M;
    int T;
    cin >> H >> M;
    cin >> T;
    if((M+T) >= 60) {
        H = (H + (M+T)/60)%24;}
    M = (M + T)%60;
    cout << H << " " << M; 
}