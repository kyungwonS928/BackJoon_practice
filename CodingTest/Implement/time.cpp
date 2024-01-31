#include<iostream>
#include<string>
#include<sstream>
using namespace std;


int main() {

    int hour;
    cin >> hour;
    int cnt;
    string N = to_string(hour);

    for(int h = 0; h<=hour; h++) {
        for(int m = 0; m<60; m++) {
            for(int s = 0; s<60; s++) {
                if (to_string(h).find(N) || to_string(m).find(N) || to_string(s).find(N) ) {
                    cnt++;
                    cout << s;
                }
            }
        }
    }

    cout << cnt;
    return 0;
}