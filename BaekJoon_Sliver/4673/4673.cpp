#include <iostream>
using namespace std;

int arr[10001] = {0,};

void constructor(int x) {
    int con = x;

    while (x > 0) {
        con += (x % 10);
        x /= 10;
    }

    // con 값이 배열 arr의 범위 내에 있는지 확인
    if (con <= 10000) {
        arr[con] = 1;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    arr[0] = 1;

    for (int i = 1; i < 10001; i++) {
        constructor(i);
    }

    for (int i = 0; i < 10001; i++) {
        if (arr[i] == 0) {
            cout << i << '\n';
        }
    }

    return 0;
}