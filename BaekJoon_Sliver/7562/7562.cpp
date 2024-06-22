#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int l, n, m, y, x;
int dx[8] = {1, 1, 2, 2, -1, -1, -2, -2};
int dy[8] = {2, -2, 1, -1, 2, -2, 1, -1};

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie();
	int T;
	cin >> T;

	while (T--)
	{
		int board[302][302] = {
			0,
		};
		int dist[302][302] = {
			0,
		};

		cin >> l >> n >> m >> x >> y;

		queue<pair<int, int>> Q;
		Q.push({n, m});

		if (n == x && m == y)
		{
			cout << 0 << '\n';
			continue;
		}
		while (!Q.empty())
		{
			pair<int, int> cur = Q.front();
			Q.pop();
			for (int dir = 0; dir < 8; dir++)
			{
				int nx = cur.X + dx[dir];
				int ny = cur.Y + dy[dir];

				if (nx < 0 || nx >= l || ny < 0 || ny >= l)
					continue;
				if (dist[nx][ny] > 0 || (nx == n && ny == m))
					continue;
				if (nx == x && ny == y)
				{
					cout << dist[cur.X][cur.Y] + 1 << '\n';
					goto end_case;
				}

				dist[nx][ny] = dist[cur.X][cur.Y] + 1;
				Q.push({nx, ny});
			}
		}
	end_case:;
	}
}

// board에 대해서 아무런 조건이 없기 때문에, 보드 사이즈만 지정해주면 됨(board에 대한 조작이 필요없음)