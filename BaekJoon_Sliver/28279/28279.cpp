#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	deque<int> d;

	while (N--)
	{
		int query;
		cin >> query;

		if (query == 1)
		{
			int X;
			cin >> X;
			d.push_front(X);
		}
		else if (query == 2)
		{
			int X;
			cin >> X;
			d.push_back(X);
		}
		else if (query == 3)
		{
			if (!d.empty())
			{
				cout << d.front() << '\n';
				d.pop_front();
			}
			else
				cout << -1 << '\n';
		}
		else if (query == 4)
		{
			if (!d.empty())
			{
				cout << d.back() << '\n';
				d.pop_back();
			}
			else
				cout << -1 << '\n';
		}
		else if (query == 5)
		{
			cout << d.size() << '\n';
		}
		else if (query == 6)
		{
			if (d.empty())
				cout << 1 << '\n';
			else
				cout << 0 << '\n';
		}
		else if (query == 7)
		{
			if (!d.empty())
				cout << d.front() << '\n';
			else
				cout << -1 << '\n';
		}
		else if (query == 8)
		{
			if (!d.empty())
				cout << d.back() << '\n';
			else
				cout << -1 << '\n';
		}
	}

	return 0;
}
