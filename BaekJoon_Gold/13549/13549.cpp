#include <bits/stdc++.h>
using namespace std;

int board[100001];

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, K;
	cin >> N >> K;

	for (int i = 0; i < 100001; i++)
	{
		board[i] = -1;
	}

	board[N] = 0;

	deque<int> q;
	q.push_front(N);

	while (!q.empty())
	{
		int cur = q.front();
		q.pop_front();

		if (cur == K)
		{
			cout << board[cur] << '\n';
			return 0;
		}

		int move = 2 * cur;
		if (move <= 100000 && board[move] == -1)
		{
			board[move] = board[cur];
			q.push_front(move);
		}

		int left = cur - 1;
		if (left >= 0 && board[left] == -1)
		{
			board[left] = board[cur] + 1;
			q.push_back(left);
		}

		int right = cur + 1;
		if (right <= 100000 && board[right] == -1)
		{
			board[right] = board[cur] + 1;
			q.push_back(right);
		}
	}

	return 0;
}
