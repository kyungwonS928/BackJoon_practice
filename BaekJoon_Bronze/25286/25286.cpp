#include <iostream>
#include <stack>
using namespace std;

int main()
{

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int day[12] = {
		31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	int T;
	cin >> T;

	while (T--)
	{
		int y, m;
		cin >> y >> m;

		bool isLeap = false;

		if (y % 4 == 0)
		{
			if (y % 100 == 0)
			{
				if (y % 400 == 0)
				{
					isLeap = true;
				}
			}
			else
			{
				isLeap = true;
			}
		}

		if (m == 3)
		{
			if (isLeap)
			{
				cout << y << " " << 2 << " " << day[1] + 1 << '\n';
			}
			else
			{
				cout << y << " " << 2 << " " << day[1] << '\n';
			}
		}
		else if (m == 1)
		{
			cout << y - 1 << " " << 12 << " " << day[11] << '\n';
		}
		else
		{
			cout << y << " " << m - 1 << " " << day[m - 2] << '\n';
		}
	}
}