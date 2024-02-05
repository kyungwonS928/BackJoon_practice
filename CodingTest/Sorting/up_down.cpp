#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<int> arr;
    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        int n;
        cin >> n;
        arr.push_back(n);
    }

    sort(arr.begin(), arr.begin()+N, greater<>());

    for(int i = 0; i<N; i++) {
        cout << arr[i] << " ";
    }

    return 0;
}
