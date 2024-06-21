#include <bits/stdc++.h>
using namespace std;

int board[502][502] = {
	0,
};
bool vis[502][502] = {
	0,
};

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> board[i][j];
		}
	}

	int max_val = 0;
	int cnt = 0;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (board[i][j] == 0 || vis[i][j])
				continue;
			cnt++;
			queue<pair<int, int>> Q;

			vis[i][j] = 1;
			Q.push({i, j});

			int area = 0;
			while (!Q.empty())
			{
				area++;
				pair<int, int> cur = Q.front();
				Q.pop();

				for (int dir = 0; dir < 4; dir++)
				{
					int nx = cur.first + dx[dir];
					int ny = cur.second + dy[dir];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;
					if (vis[nx][ny] || board[nx][ny] != 1)
						continue;

					vis[nx][ny] = 1;
					Q.push({nx, ny});
				}
			}
			max_val = max(max_val, area);
		}
	}

	cout << cnt << '\n'
		 << max_val;
}