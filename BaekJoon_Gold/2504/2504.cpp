#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string str;
	cin >> str;

	stack<char> block;
	int result = 0;
	int temp = 1;
	for (int i = 0; i < str.length(); i++)
	{

		if (str[i] == '(')
		{
			temp *= 2;
			block.push(str[i]);
		}
		else if (str[i] == '[')
		{
			temp *= 3;
			block.push(str[i]);
		}
		else if (str[i] == ')')
		{
			if (block.empty() || block.top() != '(')
			{
				result = 0;
				break;
			}
			else if (str[i - 1] == '(')
			{
				result += temp;
			}
			block.pop();
			temp /= 2;
		}
		else if (str[i] == ']')
		{
			if (block.empty() || block.top() != '[')
			{
				result = 0;
				break;
			}
			else if (str[i - 1] == '[')
			{
				result += temp;
			}
			block.pop();
			temp /= 3;
		}
	}

	if (!block.empty())
	{
		result = 0;
	}
	cout << result;
	return 0;
}