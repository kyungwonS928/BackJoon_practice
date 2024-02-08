#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<pair<int, string>> members;
    int N, M;
    cin >> N >> M;
    vector<string> cards;

    for(int i = 0; i<N; i++) {
        string n;
        cin >> n;
        cards.push_back(n);
    }
    
    sort(cards.begin(), cards.begin()+N);

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