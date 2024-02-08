#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

bool recursive(vector<int> arr, int target, int start, int end) {

    if(start > end) return;
    int mid = (start+end) /2;

    if(arr[mid] == target) return true;
    else if(arr[mid] > target) return recursive(arr, target, start, mid-1);
    else return recursive(arr, target, start+1, end);

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<pair<int, string>> members;
    int N;
    cin >> N;
    vector<int> cards;

    for(int i = 0; i<N; i++) {
        int n;
        cin >> n;
        cards.push_back(n);
    }

    int M;
    cin>>M;
    vector<int> num;
    for(int i = 0; i<M; i++) {
        int m;
        cin >> m;
        num.push_back(m);
    }

    sort(cards.begin(), cards.begin()+N);

    
    for(int i = 0; i<M; i++) {
        if(recursive(cards, num[i], 0, N-1)) {
            cout << "yes" << " ";
        } else cout << "no" << " ";
    }
    
    
    return 0;

} 