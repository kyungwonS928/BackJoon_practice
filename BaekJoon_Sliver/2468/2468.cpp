#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

int board[102][102];
int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };
int visited[102][102];

int main()
{
	int N;
	cin >> N;

	int max_val = 0;
	int min_val = 101;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
			if (max_val < board[i][j]) max_val = board[i][j];
			if (min_val > board[i][j]) min_val = board[i][j];
		}
	}

	queue<pair<int, int>> q;
	int max_area = 0;
	for (int h = min_val; h <= max_val; h++) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = 0;
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//h 보다 높거나 같으면 잠기지 않음
				
				if (board[i][j] >= h && visited[i][j] == 0) {

					cnt++;
					q.push({ i, j });
					visited[i][j] = 1;

					while (!q.empty()) {
						pair<int, int> cur = q.front();
						q.pop();

						for (int dir = 0; dir < 4; dir++) {

							int nx = cur.first + dx[dir];
							int ny = cur.second + dy[dir];

							if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
							if (board[nx][ny] < h || visited[nx][ny] == 1) continue;

							visited[nx][ny] = 1;
							q.push({ nx, ny });
						}
					}
				}
			}
		}

		max_area = max(max_area, cnt);


	}

	cout << max_area << '\n';
	
	
	
}
