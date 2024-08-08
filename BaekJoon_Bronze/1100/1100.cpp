#include <bits/stdc++.h>
using namespace std;

int main()
{

	int sum = 0;

	for (int i = 0; i < 8; i++)
	{
		for (int j = 0; j < 8; j++)
		{
			char c;
			cin >> c;
			if ((i + j) % 2 == 0 && c == 'F')
				sum++;
		}
	}

	cout << sum;
}
