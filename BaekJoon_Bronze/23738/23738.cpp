#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	string str;

	cin >> str;

	string result = "";

	for (int i = 0; i < str.length(); i++)
	{
		str[i] = tolower(str[i]);
		if (str[i] == 'b')
			result += 'v';
		else if (str[i] == 'e')
			result += "ye";
		else if (str[i] == 'h')
			result += 'n';
		else if (str[i] == 'p')
			result += 'r';
		else if (str[i] == 'c')
			result += 's';
		else if (str[i] == 'y')
			result += 'u';
		else if (str[i] == 'x')
			result += 'h';
		else
			result += str[i];
	}

	cout << result;
}