#include<iostream>
#include<sstream>
#include <string>  
using namespace std;

int main() {
    string n;
    
    while(!cin.eof() ) {
        getline(cin, n);
        cout << n << '\n';
    }

}