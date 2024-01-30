#include<iostream>
#include<string>
#include <algorithm>
using namespace std;


int main() {
    int N;
    cin>> N;
    int title =0;
    int cnt =0;
    int temp;

    while(cnt!=N) {
        title++;
        temp = title;

        while(title!=0) {
            if(temp % 1000) {
                cnt++;
                break;
            } else temp/10;
        }
    }
    
    cout << title;

    return 0;
}