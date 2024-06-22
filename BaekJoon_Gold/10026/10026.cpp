#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

string board[102];
bool vis[102][102];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int N;
queue<pair<int, int>> B;

void BFS(int i, int j)
{

	vis[i][j] = 1;
	B.push({i, j});
	while (!B.empty())
	{
		pair<int, int> cur = B.front();
		B.pop();

		for (int dir = 0; dir < 4; dir++)
		{
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (vis[nx][ny] || board[nx][ny] != board[cur.X][cur.Y])
				continue;
			vis[nx][ny] = 1;
			B.push({nx, ny});
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie();

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> board[i];
	}

	int blue = 0;
	int red = 0;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (!vis[i][j])
			{
				BFS(i, j);
				blue++;
			}
		}
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (board[i][j] == 'G')
				board[i][j] = 'R';
		}
		fill(vis[i], vis[i] + N, 0);
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (!vis[i][j])
			{
				BFS(i, j);
				red++;
			}
		}
	}

	cout << blue << " " << red;
}