#include<iostream>
using namespace std;


int main() {
    int first, second;

    while(1) {

    cin >> first >> second;    
    if(first ==0 && second ==0) {
        break;
    }

        if(first % second == 0) {
            cout <<"multiple" << endl;
        } else if (second%first == 0) {
            cout <<"factor" <<endl;
        } else {
            cout <<"neither" << endl;
        }
    }

    return 0;

}