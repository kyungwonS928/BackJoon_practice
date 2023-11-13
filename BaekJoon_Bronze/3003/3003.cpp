#include<iostream>
using namespace std;

int main() {
    
    int chess[6] = {1, 1, 2, 2, 2, 8};
    double input[6] ={0, };

    for(int i = 0; i<6; i++) {
        cin >> input[i];
    }

    for(int i = 0; i<6; i++){
        input[i] = chess[i] - input[i];
    }

    for(int i = 0; i<6; i++) {
        cout << input[i] << " ";
    }

}