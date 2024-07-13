#include <iostream>
#include <string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	string board[4] = {"ACAG", "CGTA", "ATCG", "GAGT"};

	int N;
	cin >> N;

	string str;
	cin >> str;

	while (N > 1)
	{
		char first = str[N - 2];
		char second = str[N - 1];

		int f_idx, s_idx;
		if (first == 'A')
			f_idx = 0;
		else if (first == 'G')
			f_idx = 1;
		else if (first == 'C')
			f_idx = 2;
		else if (first == 'T')
			f_idx = 3;

		if (second == 'A')
			s_idx = 0;
		else if (second == 'G')
			s_idx = 1;
		else if (second == 'C')
			s_idx = 2;
		else if (second == 'T')
			s_idx = 3;

		str[N - 2] = board[f_idx][s_idx];
		N--;
	}

	cout << str[0] << '\n';

	return 0;
}
