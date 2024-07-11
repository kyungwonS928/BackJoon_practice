#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int t;
	cin >> t;
	while (t--)
	{
		int n;
		cin >> n;
		vector<int> store(n);
		for (int i = 0; i < n; i++)
		{
			cin >> store[i];
		}

		sort(store.begin(), store.end());

		int result = (store[n - 1] - store[0]) * 2;
		cout << result << '\n';
	}
	return 0;
}