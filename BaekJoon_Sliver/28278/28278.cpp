#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int stack[1000001] = {
		0,
	};
	int p = 0;
	int N;
	cin >> N;
	int s;
	while (N--)
	{
		cin >> s;

		if (s == 1)
		{
			int x;
			cin >> x;
			stack[++p] = x;
		}
		else if (s == 2)
		{
			if (p != 0)
			{
				cout << stack[p--] << '\n';
			}
			else
			{
				cout << -1 << '\n';
			}
		}
		else if (s == 3)
		{
			cout << p << '\n';
		}
		else if (s == 4)
		{
			if (p == 0)
				cout << 1 << '\n';
			else
				cout << 0 << '\n';
		}
		else if (s == 5)
		{
			if (p != 0)
			{
				cout << stack[p] << '\n';
			}
			else
			{
				cout << -1 << '\n';
			}
		}
	}

	return 0;
}