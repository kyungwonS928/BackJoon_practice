#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	int M;
	cin >> M;

	vector<vector<int>> adj(N + 1);
	vector<int> visited(N + 1, 0);

	queue<int> que;
	for (int i = 0; i < M; i++)
	{
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}

	que.push(1);
	visited[1] = 1;
	int sum = 0;
	while (!que.empty())
	{
		int cur = que.front();
		que.pop();

		for (int next : adj[cur])
		{
			if (!visited[next])
			{
				que.push(next);
				visited[next] = 1;
				sum++;
			}
		}
	}

	cout << sum << "\n";

	return 0;
}