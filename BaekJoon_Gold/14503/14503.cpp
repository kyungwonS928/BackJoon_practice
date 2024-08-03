#include <bits/stdc++.h>
using namespace std;

int board[52][52];
int dx[4] = {-1, 0, 1, 0}; // 북, 동, 남, 서
int dy[4] = {0, 1, 0, -1};

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie();

	int N, M;

	cin >> N >> M;

	int r, c, d;
	cin >> r >> c >> d;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> board[i][j];
		}
	}

	int sum = 0;
	while (true)
	{

		if (board[r][c] == 0)
		{
			cout << "first" << r << " second  " << c << '\n';
			board[r][c] = 2;
			sum++;
		}

		bool isClean = false;
		for (int dir = 0; dir < 4; dir++)
		{
			d = (d + 3) % 4;
			int nx = r + dx[d];
			int ny = c + dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
			{

				continue;
			}

			if (board[nx][ny] == 0)
			{

				r = nx;
				c = ny;
				isClean = true;
				break;
			}
		}

		if (!isClean)
		{
			int nx = r - dx[d];
			int ny = c - dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 1)
				break;

			r = nx;
			c = ny;
		}
	}

	cout << sum;
}