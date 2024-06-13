#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, f;
	cin >> n >> f;

	int num = (n / 100) * 100;

	for (int i = 0; i < 100; i++)
	{
		if (num % f == 0)
		{
			break;
		}
		else
		{
			num++;
		}
	}

	if (num % 100 < 10)
	{
		cout << 0 << num % 100;
	}
	else
	{
		cout << num % 100;
	}

	return 0;
}