#include<iostream>
using namespace std;

int main() {
    
    int N;
    cin >> N;

    for(int i = 1; i<N; i++) {
        for(int k = i; k<N; k++) {
            cout << " ";
        }
        for(int k=1; k <= 2*i-1; k++) cout << '*';
        cout << endl;
    }

    for(int i = N; i>0; i--) {
        for(int k = N; k>i; k--) {
            cout << " ";
        }
        for(int k = 2*i-1; k>0; k--) {
            cout << '*';
        }
        if(i != 1) cout << endl;

        
    }

}