#include <iostream>
#include <string>
#include <vector>
#include <stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	string s;
	cin >> s;

	int count = 0;
	stack<char> c;
	for (int i = 0; i < s.length(); i++)
	{

		if (!c.empty() && s[i] == ')')
		{
			if (s[i - 1] == ')')
			{
				count++;
			}
			else
			{
				count += c.size();
			}
			c.pop();
		}
		else
		{
			c.push(s[i]);
		}
	}

	cout << count;
}