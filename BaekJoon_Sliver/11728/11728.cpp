#include<iostream>
using namespace std;

int a[1000001], b[1000001], mergeArr[2000002];


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    for(int i = 0; i<N; i++) cin >> a[i];
    for(int i = 0; i<M; i++) cin >> b[i];

    int aidx = 0, bidx= 0;
    for(int i = 0; i<N+M; i++) {
        if(aidx == N) {
            mergeArr[i] = b[bidx++];
            continue;
        } else if(bidx == M) {
            mergeArr[i] = a[aidx++];
            continue;
        }

        if(a[aidx] < b[bidx]) mergeArr[i] = a[aidx];
        else if(a[aidx] > b[bidx]) mergeArr[i] = b[bidx];

    }

    for(int i = 0; i<N+M; i++) cout << mergeArr[i] << " ";

    
    return 0;

}