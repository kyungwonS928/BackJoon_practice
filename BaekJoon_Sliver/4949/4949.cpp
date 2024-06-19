#include <bits/stdc++.h>
using namespace std;

bool isBalanced(const string &s)
{
	stack<char> stk;
	for (char ch : s)
	{
		if (ch == '(' || ch == '[')
		{
			stk.push(ch);
		}
		else if (ch == ')')
		{
			if (stk.empty() || stk.top() != '(')
			{
				return false;
			}
			stk.pop();
		}
		else if (ch == ']')
		{
			if (stk.empty() || stk.top() != '[')
			{
				return false;
			}
			stk.pop();
		}
	}
	return stk.empty();
}

int main()
{
	string str;
	while (true)
	{
		getline(cin, str);
		if (str == ".")
			break;

		str.pop_back();

		if (isBalanced(str))
		{
			cout << "yes" << endl;
		}
		else
		{
			cout << "no" << endl;
		}
	}
	return 0;
}
