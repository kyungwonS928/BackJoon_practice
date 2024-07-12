#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <queue>
using namespace std;

int board[102][102];
int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { 1, 0, -1, 0};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N;
	cin >> N;

	int K;
	cin >> K;

	for (int i = 0; i < K; i++) {
		int m, n;
		cin >> m >> n;
		
		board[m-1][n - 1] = 1;
	}
	

	
	int L;
	cin >> L;

	queue<pair<int, int>> rotation;
	deque<pair<int, int>> snake;
	snake.push_front({ 0, 0 });

	int total_time = 1;

	for (int i = 0; i < L; i++) {
		int x;
		char c;
		cin >> x >> c;

		rotation.push({ x, c });
	}
	
	
	int dir_idx = 0;
	while (true) {

		
		int nx = snake.front().first + dx[dir_idx];
		int ny = snake.front().second + dy[dir_idx];
		
		if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
			break;
		} 
		
		//자기자신의 몸에 부딪히는 코드
		for (int i = 0; i < snake.size(); i++) {
			if (nx == snake[i].first && ny == snake[i].second)
				goto end_point;
		}
		

		snake.push_front({ nx, ny });
		//사과가 있는 칸
		if (board[nx][ny] == 1) {
			board[nx][ny] = 0;
		}
		else {
			snake.pop_back();
		}
		
		
		if (!rotation.empty()) {
			int time;
			time = rotation.front().first;
			
			if (time == total_time) {
				char dir;
				dir = rotation.front().second;
				rotation.pop();

				if (dir == 'D') {
					dir_idx = (dir_idx + 1) % 4;
				}
				else {
					dir_idx = (dir_idx + 3) % 4;
				}
			}
		}
		
		total_time++;
	}
	
	end_point:
	cout << total_time;

}
