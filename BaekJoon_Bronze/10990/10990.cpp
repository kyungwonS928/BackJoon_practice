#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int input;
	cin >> input;
	for (int line = 0; line < input; line++)
	{
		for (int space = input - line - 1; space > 0; space--)
		{
			cout << ' ';
		}
		for (int star = 0; star < 2 * line + 1; star++)
		{
			if (star == 0 || star == 2 * line)
			{
				cout << '*';
			}
			else
			{
				cout << ' ';
			}
		}
		cout << '\n';
	}
	return 0;
}