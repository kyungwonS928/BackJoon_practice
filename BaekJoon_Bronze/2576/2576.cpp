#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N = 7;
	int sum = 0;
	int min_val = 100;

	while (N--)
	{
		int n;
		cin >> n;

		if (n % 2 != 0)
		{
			sum += n;
			min_val = min(n, min_val);
		}
	}

	if (sum != 0)
		cout << sum << '\n'
			 << min_val;
	else
		cout << -1;
}