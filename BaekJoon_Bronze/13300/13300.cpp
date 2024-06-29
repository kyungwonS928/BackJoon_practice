#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N, K;

	cin >> N >> K;

	int girl[7] = {
		0,
	};
	int boy[7] = {
		0,
	};

	while (N--)
	{
		int s, y;
		cin >> s >> y;

		if (s == 0)
		{
			girl[y]++;
		}
		else
		{
			boy[y]++;
		}
	}

	int room = 0;

	for (int i = 1; i < 7; i++)
	{
		room += girl[i] / K;
		room += boy[i] / K;

		if (girl[i] % K != 0)
		{
			room++;
		}
		if (boy[i] % K != 0)
		{
			room++;
		}
	}

	cout << room;
	return 0;
}