
#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	int y = 0, m = 0;

	for (int i = 0; i < N; i++)
	{
		int call;
		cin >> call;

		y += (call / 30 + 1) * 10;
		m += (call / 60 + 1) * 15;
	}

	if (y < m)
		cout << "Y " << y << '\n';
	else if (y > m)
		cout << "M " << m << '\n';
	else
		cout << "Y M " << y << '\n';

	return 0;
}
