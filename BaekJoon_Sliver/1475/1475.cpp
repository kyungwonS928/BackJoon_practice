#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
	int N;
	cin >> N;

	int num[10] = {
		0,
	};

	while (N > 0)
	{
		int n = N % 10;
		N /= 10;
		cout << n;
		if (n == 6 || n == 9)
		{
			if (num[6] < num[9])
			{
				num[6]++;
			}
			else
			{
				num[9];
			}
		}
		else
		{
			num[n]++;
		}
	}

	int max = *max_element(num, num + 10);

	cout << max;
}