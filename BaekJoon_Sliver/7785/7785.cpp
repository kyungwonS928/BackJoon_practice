#include <iostream>
#include <set>
#include <string>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    set<string> mem;

    for (int i = 0; i < N; i++) {
        string name, status;
        cin >> name >> status;

        if (status == "enter") {
            mem.insert(name);
        } else {
            mem.erase(name);
        }
    }

    // set은 자동으로 정렬되므로 추가 정렬이 필요하지 않음
    // 정렬된 역순으로 출력
    for (auto it = mem.rbegin(); it != mem.rend(); ++it) {
        cout << *it << '\n';
    }

    return 0;
}
