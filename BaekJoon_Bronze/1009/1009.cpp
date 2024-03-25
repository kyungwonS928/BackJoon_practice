#include<iostream>
#include<math.h>
using namespace std;

int main() {

    int T;
    cin >> T;
    for(int i = 0; i<T; i++) {

    int a, b;
    cin >> a >> b;
    
    int c = 1;
    for(int j = 0; j<b; j++) {
        c = (c*a) %10;
    }
    

    if(c == 0) {
        cout << 10 << '\n';
    } else {
        cout << c << '\n';
    }
    
        
    }


}