#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	string a, b;
	cin >> a >> b;

	while (a.length() < b.length())
		a = '0' + a;
	while (b.length() < a.length())
		b = '0' + b;
	string result = "";

	for (int i = a.length() - 1; i >= 0; i--)
	{
		result = to_string((a[i] - '0') + (b[i] - '0')) + result;
	}

	cout << result;

	return 0;
}
