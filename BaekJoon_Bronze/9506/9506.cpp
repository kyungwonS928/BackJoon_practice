#include<iostream>
#include<string>
using namespace std;


int main() {
    int x = 0;
    while (1) {
        cin >> x;
        if(x == -1) break;

        string result = "";

        int perfect = 0;
        for(int i = 1; i<=x/2; i++) {
            if(x % i == 0) {

                result += to_string(i);
                
                if ( i != x/2) {
                    result += " + ";}
                perfect += i;
            }
        }
        if(perfect == x) {
            cout << x << " = " << result << endl;
        } else {
            cout << x << " is NOT perfect." << endl;
        }
        
        
    }
    

    return 0;

}