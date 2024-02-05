#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int compare(pair<string, int> i, pair<string, int> j) {

    return i.second < j.second;

}

int main() {
    vector<pair<string, int>> arr;
    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        string s;
        int n;
        cin >> s >> n;
        arr.push_back({ s, n });
    }

    sort(arr.begin(), arr.begin() + N, compare);

    for (int i = 0; i < N; i++) {
        cout << arr[i].first << " ";
    }

    return 0;
}
