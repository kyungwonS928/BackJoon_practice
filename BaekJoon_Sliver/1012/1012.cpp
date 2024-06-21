#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int board[50][50];
bool vis[50][50];
int n, m, k, cnt;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie();
	int T;
	cin >> T;

	while (T--)
	{
		cin >> m >> n >> k;

		for (int i = 0; i < n; i++)
		{
			fill(board[i], board[i] + m, 0);
			fill(vis[i], vis[i] + m, false);
		}

		while (k--)
		{
			int i, j;
			cin >> i >> j;
			board[j][i] = 1;
		}
		cnt = 0;
		queue<pair<int, int>> Q;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (board[i][j] == 1 && !vis[i][j])
				{
					cnt++;
					vis[i][j] = 1;
					Q.push({i, j});

					while (!Q.empty())
					{

						pair<int, int> cur = Q.front();
						Q.pop();
						for (int dir = 0; dir < 4; dir++)
						{
							int nx = cur.first + dx[dir];
							int ny = cur.second + dy[dir];
							if (nx < 0 || nx >= n || ny < 0 || ny >= m)
								continue;
							if (vis[nx][ny] || board[nx][ny] == 0)
								continue;
							vis[nx][ny] = 1;
							Q.push({nx, ny});
						}
					}
				}
			}
		}
		cout << cnt << '\n';
	}
}