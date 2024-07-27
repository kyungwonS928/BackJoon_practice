#include <bits/stdc++.h>
using namespace std;

int main()
{

	int t;
	cin >> t;

	while (t--)
	{
		int n;
		cin >> n;

		queue<pair<int, int>> que;
		vector<pair<int, int>> loc(n + 2);
		vector<bool> visited(n + 2, false);

		for (int i = 0; i < n + 2; i++)
		{
			cin >> loc[i].first >> loc[i].second;
		}

		bool reach = false;

		que.push(loc[0]);
		visited[0] = true;

		while (!que.empty())
		{
			pair<int, int> cur = que.front();
			que.pop();

			if (abs(cur.first - loc[n + 1].first) + abs(cur.second - loc[n + 1].second) <= 1000)
			{
				reach = true;
				break;
			}

			for (int i = 1; i < n + 2; i++)
			{
				if (abs(cur.first - loc[i].first) + abs(cur.second - loc[i].second) <= 1000 && visited[i] == false)
				{
					que.push(loc[i]);
					visited[i] = true;
				}
			}
		}

		if (reach)
			cout << "happy" << '\n';
		else
			cout << "sad" << '\n';
	}
}