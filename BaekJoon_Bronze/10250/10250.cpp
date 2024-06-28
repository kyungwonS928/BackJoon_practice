#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int T;
	cin >> T;

	while (T--)
	{

		int h, w, r;
		cin >> h >> w >> r;

		int floor = (r % h == 0) ? h : r % h;
		int room = (r % h == 0) ? r / h : r / h + 1;

		cout << floor * 100 + room << '\n';
	}
}