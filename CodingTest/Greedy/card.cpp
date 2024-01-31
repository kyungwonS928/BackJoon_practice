#include<iostream>
#include<algorithm>
using namespace std;

//각 행마다 가장 작은수를 찾은 뒤에 그 수중에서 가장 큰수
int main() {
    int num[100][100];
    int N, M;
    cin >> N >> M;
    int result = 0;

    for(int i = 0; i<N; i++) {
        for(int j = 0; j<M; j++) {
            cin >> num[i][j];
        }
        sort(num[i], num[i]+M);
    }
    
    for(int i = 0; i<N; i++) {
        if(result < num[i][0]) {
            result = num[i][0];
        }
    }
    cout << result;
    return 0;
}