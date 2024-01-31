#include<iostream>
#include<algorithm>
using namespace std;


int main() {
    int num[1000];
    int N, M, K;
    cin >> N >> M >> K;
    int result = 0;

    for(int i = 0; i<N; i++){
        cin >> num[i];
    }
    sort(num, num+N);

    for(int i = 0; i < M; i++) {
        for(int j = 0; j < K; j++) {
            result += num[N-1];
            i++;
        }
        result += num[N-2];
    }

    cout << result;
    return 0;
}