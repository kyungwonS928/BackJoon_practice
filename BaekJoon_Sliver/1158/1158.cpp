#include <iostream>
#include <algorithm>
#include <string>
#include <list>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, K;
	cin >> N >> K;

	list<int> Josephus;
	auto cur = Josephus.begin();

	for (int i = 1; i <= N; i++)
	{
		Josephus.push_back(i);
	}

	cout << '<';

	while (!Josephus.empty())
	{
		for (int i = 0; i < K; i++)
		{
			cur++;
			if (cur == Josephus.end())
				cur = Josephus.begin();
		}

		cout << *cur;
		cur = --Josephus.erase(cur);
		if (!Josephus.empty())
			cout << ", ";
	}

	cout << ">";

	return 0;
}