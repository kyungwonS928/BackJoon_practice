#include <iostream>
#include <deque>
using namespace std;

int main()
{

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	deque<int> deq;

	string s;

	while (N > 0)
	{

		cin >> s;

		int result = -1;

		if (s == "push_front")
		{
			int n;
			cin >> n;
			deq.push_front(n);
		}
		else if (s == "push_back")
		{
			int n;
			cin >> n;
			deq.push_back(n);
		}
		else if (s == "pop_front")
		{
			if (!deq.empty())
			{
				cout << deq.front();
				deq.pop_front();
			}
			else
				cout << -1;

			cout << "\n";
		}
		else if (s == "pop_back")
		{
			if (!deq.empty())
			{
				cout << deq.back();
				deq.pop_back();
			}
			else
				cout << -1;
			cout << "\n";
		}
		else if (s == "size")
		{
			cout << deq.size() << "\n";
		}
		else if (s == "empty")
		{
			if (!deq.empty())
			{
				cout << 0;
			}
			else
			{
				cout << 1;
			}
			cout << "\n";
		}
		else if (s == "front")
		{
			if (!deq.empty())
			{
				cout << deq.front();
			}
			else
				cout << -1;

			cout << "\n";
		}
		else if (s == "back")
		{
			if (!deq.empty())
			{
				cout << deq.back();
			}
			else
				cout << -1;

			cout << "\n";
		}

		N--;
	}
}