#include <bits/stdc++.h>
using namespace std;

int main()
{

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m;
	cin >> n >> m;

	deque<int> deq;

	for (int i = 1; i <= n; i++)
	{
		deq.push_back(i);
	}

	int num;
	int cnt = 0;
	int temp = 0;
	while (m--)
	{
		cin >> num;
		auto index = find(deq.begin(), deq.end(), num) - deq.begin();
		cout << index;

		while (true)
		{
			if (num == deq.front())
			{
				deq.pop_front();
				break;
			}
			else
			{

				if (index < deq.size() / 2)
				{
					temp = deq.front();
					deq.pop_front();
					deq.push_back(temp);
				}
				else
				{
					temp = deq.back();
					deq.pop_back();
					deq.push_front(temp);
				}
			}
		}
	}
}
