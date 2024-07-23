#include <bits/stdc++.h>
using namespace std;

int rsp(char a, char b)
{

	if (a == 'S')
	{
		if (b == 'S')
			return 1;
		else if (b == 'P')
			return 2;
	}
	else if (a == 'R')
	{
		if (b == 'R')
			return 1;
		else if (b == 'S')
			return 2;
	}
	else if (a == 'P')
	{
		if (b == 'P')
			return 1;
		else if (b == 'R')
			return 2;
	}

	return 0;
}

int main()
{

	int R;
	cin >> R;
	string sang;
	cin >> sang;

	int N;
	cin >> N;
	vector<string> friends(N);
	for (int i = 0; i < N; i++)
	{
		cin >> friends[i];
	}

	int score = 0;
	int max_val = 0;
	for (int i = 0; i < R; i++)
	{
		int rrsspp[3] = {0, 0, 0};
		for (int j = 0; j < N; j++)
		{
			rrsspp[0] += rsp('S', friends[j][i]);
			rrsspp[1] += rsp('P', friends[j][i]);
			rrsspp[2] += rsp('R', friends[j][i]);

			score += rsp(sang[i], friends[j][i]);
		}
		max_val = max(rrsspp[0], max(rrsspp[1], rrsspp[2]));
	}

	cout << score << '\n'
		 << max_val << '\n';
}