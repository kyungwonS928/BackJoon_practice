#include <bits/stdc++.h>
using namespace std;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0 - 1, 0, 1};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N, T;
	cin >> N >> T;

	vector<pair<int, string>> dist;
	dist.push_back({0, "."});

	while (N--)
	{
		int x;
		string y;
		cin >> x, y;
		dist.push_back({x, y});
	}

	dist.push_back({T, "."});

	int w = 0, h = 0;
	int dir = 0;
	for (int i = 1; i < dist.size(); i++)
	{
		int temp = dist[i].first - dist[i - 1].first;
		cout << "temp" << temp << '\n';
		w = w + temp * dx[dir];
		h = h + temp * dy[dir];
		cout << dy[dir] << '\n';

		if (dist[i].second == "right")
		{
			dir++;
			if (dir == 4)
				dir = 0;
		}
		else if (dist[i].second == "left")
		{
			dir--;
			if (dir == -1)
				dir = 3;
		}
	}

	cout << w << " " << h;
}