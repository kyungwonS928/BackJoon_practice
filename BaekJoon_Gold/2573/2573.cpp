#include <bits/stdc++.h>
using namespace std;

int board[302][302];
int zero[302][302];
int visited[302][302];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int N, M;

int BFS()
{

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			visited[i][j] = 0;
		}
	}
	int cnt = 0;
	for (int i = 1; i < N; i++)
	{
		for (int j = 1; j < M; j++)
		{
			if (board[i][j] > 0 && visited[i][j] == 0)
			{
				cnt++;
				queue<pair<int, int>> q;
				q.push({i, j});

				while (!q.empty())
				{
					pair<int, int> cur = q.front();
					q.pop();

					for (int dir = 0; dir < 4; dir++)
					{
						int nx = cur.first + dx[dir];
						int ny = cur.second + dy[dir];

						if (board[nx][ny] == 0 || visited[nx][ny] == 1)
							continue;

						visited[nx][ny] = 1;
						q.push({nx, ny});
					}
				}
			}
		}
	}

	return cnt;
}

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> board[i][j];
		}
	}

	int year = 0;
	while (true)
	{

		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				zero[i][j] = 0;
			}
		}

		for (int i = 1; i < N; i++)
		{
			for (int j = 1; j < M; j++)
			{
				if (board[i][j] > 0)
				{

					for (int dir = 0; dir < 4; dir++)
					{
						int nx = i + dx[dir];
						int ny = j + dy[dir];

						if (board[nx][ny] == 0)
							zero[i][j]++;
					}
				}
			}
		}

		for (int i = 1; i < N; i++)
		{
			for (int j = 1; j < M; j++)
			{
				board[i][j] -= zero[i][j];
				if (board[i][j] < 0)
					board[i][j] = 0;
			}
		}
		int cnt = BFS();
		year++;
		if (cnt >= 2)
		{
			cout << year;
			break;
		}
		else if (cnt == 0)
		{
			cout << 0;
			break;
		}
	}

	return 0;
}
