#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int temp = 0;

	for (int i = 0; i < 5; i++)
	{
		int n;
		cin >> n;
		temp += pow(n, 2);
	}

	cout << temp % 10;
}