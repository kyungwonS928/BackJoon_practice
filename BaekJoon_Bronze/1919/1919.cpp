#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	string a, b;
	cin >> a >> b;

	int arr1[26] = {
		0,
	};
	int arr2[26] = {
		0,
	};
	int erase = 0;

	for (int i = 0; i < a.size(); i++)
	{
		arr1[a[i] - 'a']++;
	}
	for (int i = 0; i < b.size(); i++)
	{
		arr2[b[i] - 'a']++;
	}

	for (int i = 0; i < 26; i++)
	{
		if (arr1[i] != arr2[i])
		{
			erase += abs(arr1[i] - arr2[i]);
		}
	}

	cout << erase;
}