#include<iostream>
#include<string>
using namespace std;

int main() {
    
    string str;
    string pal ="";
    int isPal = 0;

    cin >> str;

    for(int i = str.length()-1; i>=str.length()/2; i--) {
        pal += str[i];

    }
    

    for(int i = 0; i<pal.length();i++) {
        cout << pal[i] << "&" << str[i];
        if(pal[i] == str[i]) isPal =1;
        else {
            isPal =0;
            break;
        }
    }

    cout << isPal;
    
    return 0;

}