#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;

	deque<pair<int, int>> d;
	for (int i = 0; i < N; i++)
	{
		int num;
		cin >> num;
		d.push_back({i + 1, num});
	}

	while (!d.empty())
	{
		auto current = d.front();
		d.pop_front();
		cout << current.first << " ";

		if (d.empty())
			break;

		int steps = current.second;
		if (steps > 0)
		{
			for (int i = 1; i < steps; i++)
			{
				d.push_back(d.front());
				d.pop_front();
			}
		}
		else
		{
			for (int i = 0; i < abs(steps); i++)
			{
				d.push_front(d.back());
				d.pop_back();
			}
		}
	}

	return 0;
}
