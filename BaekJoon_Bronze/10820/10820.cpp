#include<iostream>
#include<sstream>
#include <string>  
#include<vector>
using namespace std;

int main() {
    string n;
    
    while(getline(cin, n)) {
        
        int lower = 0;
        int upper = 0;
        int num = 0;
        int emp = 0;
        for(int i = 0;i<n.length(); i++) {
            if(n[i] >= 65 && n[i]<=90) {
                upper++;
            } else if(n[i] >= 97 && n[i]<=122) {
                lower++;
            } else if (n[i] >= 48 && n[i]<=57) {
                num++;
            } else if(n[i] == ' ') {
                emp++;
            } 
        }

        cout << lower << " " << upper << " " << num << " " << emp << '\n';

    }

}