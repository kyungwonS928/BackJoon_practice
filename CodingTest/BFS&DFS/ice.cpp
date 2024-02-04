#include<iostream>
#include<vector>
#include<deque>
using namespace std;

bool visited[9];

vector<string> arr;

bool dfs(int x, int y) {
    if(x < 0 || x >= arr.size() || y < 0 || y>=arr[x].size()) return false;

    if(arr[x][y] == '0') {
        arr[x][y] == '1';
        dfs(x+1, y);
        dfs(x, y+1);
        dfs(x-1, y);
        dfs(x, y-1);
        return true;
    }

    return false;
}

int main() {
    int N, M;
    cin >> N >> M;

    for(int i = 0; i<N; i++) {
            string n;
            cin >> n;
            arr.push_back(n);
        
    }


    int result= 0;
    for(int i = 0; i< N; i++) {
        for(int j =0; j<M; j++) {
            if(dfs(i, j) == true) {
                result++;
            }
        }
    }

    cout << result;

    return 0;
}
