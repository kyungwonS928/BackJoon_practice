#include<iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    int counting[10001]= {0,};
    
    for(int i = 0; i< N; i++) {
        int num;
        cin >> num;
        counting[num]++;
    }

    for(int i = 0; i< 10001; i++) {
        if(counting[i] != 0) {
            for(int j = 0; j<counting[i]; j++) {
                cout << i << '\n';

            }
        }
    }

    return 0;

}