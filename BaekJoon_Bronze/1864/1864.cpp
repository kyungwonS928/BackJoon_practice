#include <bits/stdc++.h>
using namespace std;

int main()
{

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	while (true)
	{

		string str;
		cin >> str;

		if (str == "#")
			break;

		int result = 0;

		for (int i = 0; i < str.length(); i++)
		{
			int num = 0;
			if (str[i] == '-')
			{
				num = 0;
			}
			else if (str[i] == '\\')
			{
				num = 1;
			}
			else if (str[i] == '(')
			{
				num = 2;
			}
			else if (str[i] == '@')
			{
				num = 3;
			}
			else if (str[i] == '?')
			{
				num = 4;
			}
			else if (str[i] == '>')
			{
				num = 5;
			}
			else if (str[i] == '&')
			{
				num = 6;
			}
			else if (str[i] == '%')
			{
				num = 7;
			}
			else if (str[i] == '/')
			{
				num = -1;
			}

			result += num * pow(8, str.length() - i - 1);
		}
		cout << result << '\n';
	}
}
