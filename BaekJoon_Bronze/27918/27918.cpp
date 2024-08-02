#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie();

	int N;
	cin >> N;

	int D = 0, P = 0;
	for (int i = 0; i < N; i++)
	{
		char temp;
		cin >> temp;
		if (temp == 'D')
		{
			D++;
		}
		else if (temp == 'P')
			P++;

		if (abs(P - D) >= 2)
			break;
	}

	cout << D << ":" << P;
}