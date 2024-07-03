#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;
	deque<int> arr;
	vector<int> queuestack(N);

	for (int i = 0; i < N; i++)
	{
		cin >> queuestack[i];
	}
	for (int i = 0; i < N; i++)
	{
		int n;
		cin >> n;
		if (queuestack[i] == 0)
			arr.push_back(n);
	}
	int M;
	cin >> M;

	for (int i = 0; i < M; i++)
	{

		int num;
		cin >> num;
		arr.push_front(num);
		cout << arr.back() << " ";
		arr.pop_back();
	}

	return 0;
}
