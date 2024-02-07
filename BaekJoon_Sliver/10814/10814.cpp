#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

bool compare(pair<int, string> i, pair<int, string> j) {
    if(i.first == j.first) {
        return false;
    }
    
    return i.first < j.first;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<pair<int, string>> members;
    int N;
    cin >> N;

    for(int i = 0; i<N; i++) {
        string member;
        int n;
        cin >> n >> member;
        members.push_back({n, member});
    }
    
    stable_sort(members.begin(), members.begin() + N, compare);

    for(int i = 0; i<N; i++) {
        cout << members[i].first << " " << members[i].second << '\n';
    }

    
    return 0;

} 