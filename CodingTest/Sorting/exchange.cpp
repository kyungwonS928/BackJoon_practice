#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
    vector<int> arrA;
    vector<int> arrB;

    int N, K;
    cin >> N >> K;

    for (int i = 0; i < N; i++) {
        int n;
        cin >> n;
        arrA.push_back(n);
    }
    for (int i = 0; i < N; i++) {
        int m;
        cin >> m;
        arrB.push_back(m);
    }

    sort(arrA.begin(), arrA.begin() + N);
    sort(arrB.begin(), arrB.begin() + N, greater<>());

    for(int i = 0;i<K; i++) {
        arrA[i] = arrB[i];
    }
    int sum =0;
    for(int i = 0;i<N;i++) {
        sum += arrA[i];
    }

    cout << sum;

    return 0;
}
