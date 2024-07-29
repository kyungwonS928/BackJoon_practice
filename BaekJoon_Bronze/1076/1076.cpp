#include <iostream>
#include <string>
using namespace std;

int resist[10] = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
string color[10] = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

int search(string s)
{
	for (int i = 0; i < 10; i++)
	{
		if (s == color[i])
		{
			return i;
		}
	}

	return -1;
}

int main()
{

	string first, second, third;
	cin >> first >> second >> third;

	int first_idx = search(first);
	int second_idx = search(second);
	int third_idx = search(third);

	long long result = first_idx * 10 + second_idx;
	result *= resist[third_idx];

	cout << result << '\n';
	return 0;
}