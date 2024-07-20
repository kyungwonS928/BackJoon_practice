#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	long long n, m;
	cin >> n >> m;

	if (n < m)
	{

		cout << m - n - 1 << '\n';
		for (long long i = n + 1; i < m; i++)
		{
			cout << i << ' ';
		}
	}
	else if (n == m)
	{
		cout << 0 << '\n';
	}
	else
	{
		cout << n - m - 1 << '\n';
		for (long long i = m + 1; i < n; i++)
		{
			cout << i << ' ';
		}
	}
	return 0;
}