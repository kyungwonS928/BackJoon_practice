#include <iostream>
#include <queue>
using namespace std;

int main()
{

	ios::sync_with_stdio(0);
	cin.tie(0);
	int N;
	cin >> N;
	queue<int> que;
	int last = 0;

	for (int i = 1; i <= N; i++)
	{
		que.push(i);
	}

	while (que.size() != 1)
	{
		que.pop();
		last = que.front();
		que.pop();
		que.push(last);
	}

	cout << que.front();
}