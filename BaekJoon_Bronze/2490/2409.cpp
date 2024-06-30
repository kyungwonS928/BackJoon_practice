#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N = 3;

	while (N--)
	{
		int b = 0;

		for (int i = 0; i < 4; i++)
		{
			int n;
			cin >> n;
			if (n == 0)
				b++;
		}

		if (b == 0)
			cout << "E" << "\n";
		else if (b == 1)
			cout << "A" << "\n";
		else if (b == 2)
			cout << "B" << "\n";
		else if (b == 3)
			cout << "C" << "\n";
		else if (b == 4)
			cout << "D" << "\n";
	}
}