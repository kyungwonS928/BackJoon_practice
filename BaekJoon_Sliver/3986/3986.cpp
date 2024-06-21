#include <iostream>
#include <string>
#include <vector>
#include <stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N;

	cin >> N;

	int count = 0;

	while (N--)
	{
		string s;
		cin >> s;

		stack<char> c;

		for (int i = 0; i < s.length(); i++)
		{

			if (!c.empty() && c.top() == s[i])
			{

				c.pop();
			}
			else
			{
				c.push(s[i]);
			}
		}

		if (c.empty())
		{
			count++;
		}
	}

	cout << count;
}