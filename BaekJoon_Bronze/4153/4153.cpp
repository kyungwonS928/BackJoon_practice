#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	while (true)
	{
		vector<int> num(3);

		cin >> num[0] >> num[1] >> num[2];

		if (num[0] == 0 && num[1] == 0 && num[2] == 0)
			break;

		sort(num.begin(), num.end());

		int third = pow(num[3], 2);
		int rest = pow(num[0], 2) + pow(num[1], 2);

		if (third == rest)
			cout << "right";
		else
			cout << "wrong";

		cout << '\n';
	}
}