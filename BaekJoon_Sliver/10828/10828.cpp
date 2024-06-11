#include <iostream>
#include <stack>
using namespace std;

int main()
{
	int N;
	cin >> N;
	stack<int> sta;

	while (N > 0)
	{

		string s;
		cin >> s;

		if (s == "push")
		{
			int n;
			cin >> n;
			sta.push(n);
		}
		else if (s == "top")
		{
			if (!sta.empty())
				cout << sta.top();
			else
				cout << -1;

			cout << "\n";
		}
		else if (s == "size")
		{
			cout << sta.size() << "\n";
		}
		else if (s == "empty")
		{
			if (!sta.empty())
			{
				cout << 0;
			}
			else
			{
				cout << 1;
			}
			cout << "\n";
		}
		else if (s == "pop")
		{
			if (!sta.empty())
			{
				cout << sta.top();
				sta.pop();
			}
			else
				cout << -1;
			cout << "\n";
		}

		N--;
	}
}