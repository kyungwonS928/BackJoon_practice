#include <iostream>
#include <queue>
using namespace std;

int main()
{
	int N;
	cin >> N;
	queue<int> que;

	while (N > 0)
	{

		string s;
		cin >> s;

		if (s == "push")
		{
			int n;
			cin >> n;
			que.push(n);
		}
		else if (s == "front")
		{
			if (!que.empty())
				cout << que.front();
			else
				cout << -1;

			cout << "\n";
		}
		else if (s == "back")
		{
			if (!que.empty())
				cout << que.back();
			else
				cout << -1;

			cout << "\n";
		}
		else if (s == "size")
		{
			cout << que.size() << "\n";
		}
		else if (s == "empty")
		{
			if (!que.empty())
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
			if (!que.empty())
			{
				cout << que.front();
				que.pop();
			}
			else
				cout << -1;
			cout << "\n";
		}

		N--;
	}
}