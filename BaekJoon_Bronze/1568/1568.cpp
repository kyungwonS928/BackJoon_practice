#include <bits/stdc++.h>
using namespace std;

int main()
{
	int N;
	cin >> N;

	int sec = 0;
	int K = 0;

	while (N > 0)
	{
		int sum = (K * (K + 1)) / 2;
		cout << sum << '\n';
		if (sum > N)
		{
			N -= (K * (K - 1)) / 2;
			cout << "new" << N << '\n';
			sec += K - 1;
			K = 1;
		}
		else if (sum == N)
		{
			sec += K;
			break;
		}
		K++;
	}

	cout << sec;
}
