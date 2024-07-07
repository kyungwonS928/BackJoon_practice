#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;

	while (T--)
	{
		int N, M, k, D;
		cin >> N >> M >> k >> D;

		int team_in = M * (M - 1) / 2 * N * k;
		int team_out = N * (N - 1) / 2 * M * M;

		int result = D / (team_in + team_out);

		if (result == 0)
			cout << -1;
		else
			cout << result * (team_in + team_out);

		cout << '\n';
	}
	return 0;
}
