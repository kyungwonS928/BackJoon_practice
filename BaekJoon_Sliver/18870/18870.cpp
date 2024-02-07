#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;


int main() {

    int N;
    cin >> N;

    vector<int> num;
    for(int i = 0; i<N;i++) {
        int n;
        cin >> n;
        num.push_back(n);
    }

    vector<int> rating = num;

    stable_sort(rating.begin(), rating.begin() + N);
    rating.erase(unique(rating.begin(), rating.end()), rating.end());
    

    
    for(int i = 0; i<N; i++) {
        int index = lower_bound(rating.begin(), rating.end(), num[i]) - rating.begin();
		cout << index << " ";
    }

}