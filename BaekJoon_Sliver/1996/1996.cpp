#include <bits/stdc++.h>
using namespace std;

string board[1001];
int dx[8] = {0, 0, 1, -1, 1, 1, -1, -1};
int dy[8] = {1, -1, 0, 0, 1, -1, 1, -1};
char result[1001][1001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++)
	{

		cin >> board[i];
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (board[i][j] != '.')
			{
				result[i][j] = '*';
				continue;
			}
			result[i][j] = '0';
			for (int dir = 0; dir < 8; dir++)
			{
				int nx = i + dx[dir];
				int ny = j + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (board[nx][ny] == '.')
					continue;

				result[i][j] = (result[i][j]) + (board[nx][ny] - '0');

				if (result[i][j] - '0' >= 10)
					result[i][j] = 'M';
			}
		}
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			cout << result[i][j];
		}
		cout << '\n';
	}
}