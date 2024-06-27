#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	vector<int> first(5);
	vector<int> second(5);

	for (int i = 0; i < 5; i++)
	{
		cin >> first[i];
	}

	for (int i = 0; i < 5; i++)
	{
		cin >> second[i];
	}

	for (int i = 0; i < 5; i++)
	{
		if (first[i] == second[i])
		{
			cout << "N";
			return 0;
		}
	}

	cout << "Y";
}