#include <bits/stdc++.h>
using namespace std;

int main()
{
	int F, S, G, U, D;
	cin >> F >> S >> G >> U >> D;

	if (S == G)
	{
		cout << 0 << '\n';
		return 0;
	}

	vector<int> floor(F + 1, -1);
	queue<int> move;

	move.push(S);
	floor[S] = 0;

	while (!move.empty())
	{
		int current = move.front();
		move.pop();

		int uf = current + U;
		if (uf <= F && floor[uf] == -1)
		{
			floor[uf] = floor[current] + 1;
			if (uf == G)
			{
				cout << floor[uf] << '\n';
				return 0;
			}
			move.push(uf);
		}

		int df = current - D;
		if (df >= 1 && floor[df] == -1)
		{
			floor[df] = floor[current] + 1;
			if (df == G)
			{
				cout << floor[df] << '\n';
				return 0;
			}
			move.push(df);
		}
	}

	cout << "use the stairs" << '\n';
}
