#include <bits/stdc++.h>
using namespace std;

int board[102][102];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int main()
{
	int M, N, K;
	cin >> M >> N >> K;

	for (int k = 0; k < K; k++)
	{
		int x1, x2, y1, y2;
		cin >> x1 >> y1 >> x2 >> y2;

		for (int i = y1; i < y2; i++)
		{
			for (int j = x1; j < x2; j++)
			{
				board[j][i] = 1;
			}
		}
	}

	vector<int> width;
	queue<pair<int, int>> q;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (board[i][j] == 0)
			{
				q.push({i, j});
				board[i][j] = 1;
				int cnt = 1;

				while (!q.empty())
				{
					pair<int, int> cur = q.front();
					q.pop();

					for (int dir = 0; dir < 4; dir++)
					{
						int nx = cur.first + dx[dir];
						int ny = cur.second + dy[dir];

						if (nx < 0 || nx >= N || ny < 0 || ny >= M)
							continue;
						if (board[nx][ny] != 0)
							continue;

						board[nx][ny] = 1;
						q.push({nx, ny});
						cnt++;
					}
				}
				width.push_back(cnt);
			}
		}
	}

	sort(width.begin(), width.end());

	cout << width.size() << '\n';
	for (int i = 0; i < width.size(); i++)
	{
		cout << width[i] << " ";
	}
}