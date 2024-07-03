#include <iostream>
#include <stack>
using namespace std;

int main()
{

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;
	while (T--)
	{
		int day = 0;
		int N, C;
		cin >> N >> C;

		while (N)
		{
			if (N < C)
			{
				N = 0;
				day++;
			}
			else
			{
				N -= C;
				day++;
			}
		}

		cout << day << '\n';
	}
}