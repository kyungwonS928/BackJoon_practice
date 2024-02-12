#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    

    int N;
    cin >> N;

    vector<int> num;

    for(int i = 0; i<N; i++) {
        int n ;
        cin >> n;
        num.push_back(n);
    }

    int min_val = *min_element(num.begin(), num.begin() + N);
    int max_val = *max_element(num.begin(), num.begin() + N);

    cout << min_val * max_val;

    return 0;
}