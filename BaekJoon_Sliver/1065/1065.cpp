#include <iostream>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int cnt = 0;

    int N;
    cin >> N;

    if (N < 100) {
        cnt = N;
    }
    else {
        cnt = 99;
        for (int i = 100; i <= N; i++) {
            int first = i % 10;
            int second = (i / 10) % 10;
            int third = i / 100;

            if (2 * second == first + third) {
                cnt++;
            }
        }
    }




    cout << cnt;
    return 0;
}