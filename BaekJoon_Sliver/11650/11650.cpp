#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool compare(pair<int, int> i, pair<int, int> j) {
    if(i.first == j.first) {
        return i.second > j.second;
    }
    return i.first > i.first;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<pair<int, int>> num;
    int N;
    cin >> N;

    for(int i = 0; i<N; i++) {
        int x, y;
        cin >> x >>y;
        num.push_back({x, y});
    }
    
    sort(num.begin(), num.begin() + N, compare);

    for(int i = 0; i<N; i++) {
        cout << num[i].first << " " << num[i].second << '\n';
    } 
    return 0;

}