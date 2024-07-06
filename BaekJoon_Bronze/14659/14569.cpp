#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie();

	int N;
	cin >> N;

	int dragon = 0;
	int max_val = 0;
	int cnt = 0;

	for (int i = 0; i < N; i++)
	{
		int n;
		cin >> n;

		if (dragon < n)
		{
			dragon = n;
			cnt = 0;
			continue;
		}
		else
		{
			cnt++;
		}
		max_val = max(max_val, cnt);
	}

	cout << max_val;
}