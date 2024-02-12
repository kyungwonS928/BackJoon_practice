#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

int search(vector<int> arr, int target,int start, int end) {
    int mid = (start+end)/2;

    while(start<=end) {
        int total = 0;
        for(int i:arr) {
            if(i>mid) total += i-mid;
        }
        if(total < mid) end = mid-1;
        else {
            start = mid + 1;
        }
    }
    return mid;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<pair<int, string>> members;
    int N, M;
    cin >> N >> M;
    vector<int> ddeok;

    for(int i = 0; i<N; i++) {
        int n;
        cin >> n;
        ddeok.push_back(n);
    }
    
   

    
    

    return 0;

} 