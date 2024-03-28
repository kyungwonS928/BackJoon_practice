#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool compare(pair<int, int> i, pair<int, int> j) {
    return i>j;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    vector<pair<int, int>> score;

    for(int i = 0; i<8; i++) {
        int m = 0;
        cin >>m;
        score.push_back({i+1, m});
    }

    sort(score.begin(), score.end(), compare);

    vector<int> num;

    int sum = 0;
    for(int i = 0; i<5; i++) {
        num.push_back(score[i].first);
        sum+=score[i].second;
    }

    sort(num.begin(), num.begin()+5);

    cout << sum << '\n';

    for(int i = 0; i<5; i++) {
        cout << num[i] << " ";
    }

    
    return 0;

}