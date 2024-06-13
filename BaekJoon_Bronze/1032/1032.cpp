#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	string str;

	string result;

	for (int i = 0; i < n; i++)
	{
		cin >> str;
		if (i == 0)
		{
			result = str;
		}
		else
		{
			for (int j = 0; j < str.length(); j++)
			{

				if (result[j] != str[j])
				{
					result[j] = '?';
				}
			}
		}
	}

	cout << result;

	return 0;
}