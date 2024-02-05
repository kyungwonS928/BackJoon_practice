#include<iostream>
#include<vector>
#include<deque>
using namespace std;

vector<string> arr;
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

char bfs(int x, int y) {
    deque<vector<int>> queue;
    queue.push_back({x, y});

    while(!queue.empty()) {
        vector<int> n = queue.front();
        queue.pop_front();

        for(int i = 0; i<4; i++) {
            int nx = n[0] + dx[i];
            int ny = n[1] + dy[i];

            if(nx < 0 || nx >= arr.size() || ny < 0 || ny >= arr[0].size() || arr[nx][ny] != '1') {
                continue;
            }

            arr[nx][ny] = arr[x][y] + 1; // '1'에 1을 더하여 다른 문자로 표시
            queue.push_back({nx, ny});
        }
    }

    return arr[arr.size() - 1][arr[0].size() - 1];
}

int main() {
    int N, M;
    cin >> N >> M;

    for(int i = 0; i < N; i++) {
        string n;
        cin >> n;
        arr.push_back(n);
    }

    cout << bfs(0, 0) << endl;

    return 0;
}
