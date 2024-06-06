#include <iostream>
#include <algorithm>
#include <string>
#include <list>
using namespace std;

int num[100001];

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	string str;
	int M;
	cin >> str >> M;

	list<char> input;
	for (int i = 0; i < str.length(); i++)
	{
		input.push_back(str[i]);
	}
	list<char>::iterator cur = input.end();

	for (int i = 0; i < M; i++)
	{
		char c;
		cin >> c;

		if (c == 'L')
		{
			if (cur != input.begin())
				cur--;
		}
		else if (c == 'D')
		{
			if (cur != input.end())
				cur++;
		}
		else if (c == 'B')
		{
			if (cur != input.begin())
				cur = input.erase(--cur);
		}
		else
		{
			char s;
			cin >> s;
			input.insert(cur, s);
		}
	}

	for (list<char>::iterator it = input.begin(); it != input.end(); it++)
	{
		cout << *it;
	}

	return 0;
}