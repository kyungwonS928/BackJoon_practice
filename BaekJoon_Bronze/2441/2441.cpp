#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N;
	cin >> N;

	for (int i = N; i > 0; i--)
	{
		for (int j = 0; j < N - i; j++)
		{
			cout << ' ';
		}
		for (int j = i; j > 0; j--)
		{
			cout << '*';
		}
		cout << '\n';
	}
	return 0;
}