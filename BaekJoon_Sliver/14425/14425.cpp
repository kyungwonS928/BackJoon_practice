#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

bool compare(pair<string, string> i, pair<string, string> j) {
    int length;
    if(i.first.length() > j.first.length()) length = j.first.length();
    else length = i.first.length();
    for(int n = 0; n<length; n++) {
        if(i.first[n] == j.first[n]) continue;
        else return i.first[n] > j.first[n];
    }

    return i.second[0] < j.second[0];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<pair<int, string>> members;
    int N, M;
    cin >> N >> M;
    vector<pair<string, string>> cards;

    for(int i = 0; i<N; i++) {
        string n;
        string e;
        cin >> n >> e;
        cards.push_back({n, e});
    }
    
    stable_sort(cards.begin(), cards.begin()+N, compare);

    int cnt;
    for(int i = 0; i<M; i++) {
        string num;
        cin >> num;
        
        if(binary_search(cards.begin(), cards.end(), num)) {
            cnt++;
        }  
    }

    cout << cnt;
    

    return 0;

} 