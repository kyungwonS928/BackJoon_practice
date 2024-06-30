#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int N;
	cin >> N;

	while (N--)
	{
		string s, t;
		cin >> s >> t;

		sort(s.begin(), s.end());
		sort(t.begin(), t.end());

		if (s == t)
			cout << "Possible" << '\n';
		else
			cout << "Impossible" << '\n';
	}
}