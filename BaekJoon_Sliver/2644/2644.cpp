#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	int start, end;
	cin >> start >> end;

	vector<vector<int>> family(N + 1);
	vector<int> dist(N + 1, -1);
	queue<int> que;

	int M;
	cin >> M;
	for (int i = 0; i < M; i++)
	{
		int x, y;
		cin >> x >> y;
		family[x].push_back(y);
		family[y].push_back(x);
	}
	que.push(start);
	dist[start] = 0;

	while (!que.empty())
	{
		int cur = que.front();
		que.pop();

		for (int next : family[cur])
		{

			if (dist[next] == -1)
			{
				que.push(next);
				dist[next] = dist[cur] + 1;
			}
		}
	}

	cout << dist[end];
}