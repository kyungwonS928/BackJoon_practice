#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, K;
	cin >> N >> K;

	queue<int> d;

	for (int i = 1; i <= N; i++)
	{
		d.push(i);
	}

	cout << "<";
	while (!d.empty())
	{
		for (int i = 1; i < K; i++)
		{
			d.push(d.front());
			d.pop();
		}
		cout << d.front();
		d.pop();
		if (!d.empty())
			cout << ", ";
	}
	cout << ">";
}