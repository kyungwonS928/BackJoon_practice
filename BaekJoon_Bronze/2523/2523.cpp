#include <iostream>
using namespace std;

int main()
{

	int input;
	cin >> input;

	for (int line = 0; line < input; line++)
	{
		for (int star = 0; star < line + 1; star++)
		{
			cout << "*";
		}
		cout << '\n';
	}
	for (int line = input - 1; line > 0; line--)
	{
		for (int star = 0; star < line; star++)
		{
			cout << "*";
		}
		cout << '\n';
	}
}