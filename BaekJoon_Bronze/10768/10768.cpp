#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int m, d;
	cin >> m >> d;

	if (m < 2)
	{
		cout << "Before";
	}
	else if (m == 2)
	{
		if (d == 18)
			cout << "Special";
		else if (d < 18)
			cout << "Before";
		else
			cout << "After";
	}
	else
	{
		cout << "After";
	}

	return 0;
}
