#include <iostream>
#include <stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int T;
	cin >> T;

	while (T--)
	{
		stack<char> sta;
		string s;
		cin >> s;

		int right = 0;
		bool flag = true;

		for (int i = 0; i < s.length(); i++)
		{

			sta.push(s[i]);
		}

		while (!sta.empty())
		{

			char c = sta.top();
			if (c == ')')
			{
				right++;
			}
			else if (c == '(')
			{
				if (--right < 0)
				{
					flag = false;
					break;
				}
			}
			sta.pop();
		}

		if (right == 0 && flag)
		{
			cout << "YES" << '\n';
		}
		else
		{
			cout << "NO" << '\n';
		}
	}

	return 0;
}