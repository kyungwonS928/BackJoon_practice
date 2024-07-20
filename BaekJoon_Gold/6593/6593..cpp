#include <bits/stdc++.h>
using namespace std;

char board[32][32][32];
int dist[32][32][32];
int dx[6] = {0, 0, 1, -1, 0, 0};
int dy[6] = {1, -1, 0, 0, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};
int main()
{

	while (true)
	{
		int L, R, C;
		cin >> L >> R >> C;

		if (L == 0 && R == 0 && C == 0)
			break;

		queue<tuple<int, int, int>> q;
		for (int h = 0; h < L; h++)
		{
			for (int i = 0; i < R; i++)
			{
				for (int j = 0; j < C; j++)
				{
					cin >> board[h][i][j];
					dist[h][i][j] = -1;
					if (board[h][i][j] == 'S')
					{
						q.push({i, j, h});
						dist[h][i][j] = 0;
					}
				}
			}
		}
		bool isGoal = false;
		int time = 0;
		while (!q.empty())
		{
			auto cur = q.front();
			q.pop();

			for (int dir = 0; dir < 6; dir++)
			{
				int nx = get<0>(cur) + dx[dir];
				int ny = get<1>(cur) + dy[dir];
				int nz = get<2>(cur) + dz[dir];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L)
					continue;
				if (board[nz][nx][ny] == '#' || dist[nz][nx][ny] != -1)
					continue;
				if (board[nz][nx][ny] == 'E')
				{
					time = dist[get<2>(cur)][get<0>(cur)][get<1>(cur)] + 1;
					isGoal = true;
					break;
				}

				dist[nz][nx][ny] = dist[get<2>(cur)][get<0>(cur)][get<1>(cur)] + 1;
				q.push({nx, ny, nz});
			}

			if (isGoal)
				break;
		}

			if (isGoal)
			cout << "Escaped in " << time << " minute(s)." << '\n';
		else
			cout << "Trapped!" << '\n';
	}
}