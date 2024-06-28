#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	while (true)
	{
		int N, M;
		cin >> N >> M;

		if (N == 0 && M == 0)
			break;

		int copied = 0;
		int num[10001] = {0};

		while (M--)
		{
			int ticket;
			cin >> ticket;
			if (num[ticket] == 1)
			{
				copied++;
			}
			num[ticket]++;
		}

		cout << copied << '\n';
	}
}