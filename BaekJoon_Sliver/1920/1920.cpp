#include <bits/stdc++.h>
using namespace std;

int N, M;
vector<int> num;

bool binary_search(int start, int finish, int m)
{
	if (start > finish)
		return false;

	int pivot = (start + finish) / 2;

	if (num[pivot] > m)
	{
		return binary_search(start, pivot - 1, m);
	}
	else if (num[pivot] < m)
	{
		return binary_search(pivot + 1, finish, m);
	}
	else
	{
		return true;
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	num.resize(N);

	for (int i = 0; i < N; i++)
	{
		cin >> num[i];
	}

	sort(num.begin(), num.end());

	cin >> M;

	for (int i = 0; i < M; i++)
	{
		int m;
		cin >> m;

		if (binary_search(0, N - 1, m))
		{
			cout << 1 << '\n';
		}
		else
		{
			cout << 0 << '\n';
		}
	}

	return 0;
}
