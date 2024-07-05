#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie();

	while (true)
	{
		int n;
		cin >> n;
		if (n == 0)
			break;

		vector<int> num;

		while (n)
		{
			num.push_back(n % 10);
			n /= 10;
		}

		bool flag = false;
		for (int i = 0; i < num.size(); i++)
		{
			if (num[i] != num[num.size() - i - 1])
			{
				flag = true;
				break;
			}
		}

		if (flag)
			cout << "no" << '\n';
		else
			cout << "yes" << '\n';
	}
}