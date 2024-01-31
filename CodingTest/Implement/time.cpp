#include<iostream>
#include<string>
#include<sstream>
using namespace std;


int main() {

    string N;
    cin >> N;
    int cnt;

    for(int h = 0; h< 24; h++) {
        for(int m = 0; m<60; m++) {
            for(int s = 0; s<60; s++) {
                if (to_string(h).find(N) || to_string(m).find(N) || to_string(s).find(N) ) {
                    cnt++;
                }
            }
        }
    }

    cout << cnt;
    return 0;
}