#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int board[102][102][102];
int vis[102][102][102];
int dx[6] = {1, -1, 0, 0, 0, 0};
int dy[6] = {0, 0, 1, -1, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};

queue<pair<int, int>> B;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie();

	int m, n, h;
	cin >> m >> n >> h;

	queue<tuple<int, int, int>> Q;

	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < m; k++)
			{
				cin >> board[k][j][i];
				if (board[k][j][i] == 1)
				{
					Q.push({k, j, i});
					vis[k][j][i] = 1;
				}
			}
		}
	}

	while (!Q.empty())
	{
		auto [curX, curY, curZ] = Q.front();
		Q.pop();
		for (int dir = 0; dir < 6; dir++)
		{
			int nx = curX + dx[dir];
			int ny = curY + dy[dir];
			int nz = curZ + dz[dir];

			if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h)
				continue;
			if (vis[nx][ny][nz] || board[nx][ny][nz] != 0)
				continue;

			vis[nx][ny][nz] = vis[curX][curY][curZ] + 1;
			Q.push({nx, ny, nz});
		}
	}

	int day = 0;
	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < m; k++)
			{
				if (board[k][j][i] == 0 && vis[k][j][i] == 0)
				{
					cout << -1 << '\n';
					return 0;
				}
				day = max(day, vis[k][j][i]);
			}
		}
	}

	cout << day - 1 << '\n';
}