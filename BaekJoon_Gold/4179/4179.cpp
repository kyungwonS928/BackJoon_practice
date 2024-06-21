#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

string board[1002];
int fire[1002][1002];
int time_j[1002][1002];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie();

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		fill(fire[i], fire[i] + m, -1);
		fill(time_j[i], time_j[i] + m, -1);
	}

	for (int i = 0; i < n; i++)
		cin >> board[i];

	queue<pair<int, int>> Q;
	queue<pair<int, int>> J;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{

			if (board[i][j] == 'F')
			{
				fire[i][j] = 0;
				Q.push({i, j});
			}
			if (board[i][j] == 'J')
			{
				time_j[i][j] = 0;
				J.push({i, j});
			}
		}
	}

	while (!Q.empty())
	{
		auto cur = Q.front();
		Q.pop();

		for (int dir = 0; dir < 4; dir++)
		{
			int nx = cur.first + dx[dir];
			int ny = cur.second + dy[dir];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			if (fire[nx][ny] >= 0 || board[nx][ny] == '#')
				continue;

			fire[nx][ny] = fire[cur.first][cur.second] + 1;
			Q.push({nx, ny});
		}
	}

	while (!J.empty())
	{

		auto cur = J.front();
		J.pop();

		for (int dir = 0; dir < 4; dir++)
		{
			int nx = cur.first + dx[dir];
			int ny = cur.second + dy[dir];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
			{
				cout << time_j[cur.first][cur.second] + 1;
				return 0;
			}

			if (time_j[nx][ny] >= 0 || board[nx][ny] == '#')
				continue;

			if (fire[nx][ny] != -1 && fire[nx][ny] <= time_j[cur.first][cur.second] + 1)
				continue;

			time_j[nx][ny] = time_j[cur.first][cur.second] + 1;
			J.push({nx, ny});
		}
	}

	cout << "IMPOSSIBLE";
}