#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie();

	int N, K;
	cin >> N >> K;

	int board[10][10] = {
		0,
	};
	int result[100][100] = {
		0,
	};

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			cin >> board[i][j];
			for (int k = 0; k < K; k++)
			{
				for (int l = 0; l < K; l++)
				{
					result[i * K + k][j * K + l] = board[i][j];
				}
			}
		}
	}

	for (int i = 0; i < N * K; i++)
	{
		for (int j = 0; j < N * K; j++)
		{
			cout << result[i][j] << " ";
		}
		cout << '\n';
	}
}