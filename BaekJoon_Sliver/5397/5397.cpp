#include <iostream>
#include <algorithm>
#include <string>
#include <list>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;

	while (T--)
	{
		string L;
		cin >> L;

		list<char> pw;
		auto cur = pw.end();

		for (int i = 0; i < L.size(); i++)
		{
			if (L[i] == '<')
			{
				if (cur != pw.begin())
					cur--;
			}
			else if (L[i] == '>')
			{
				if (cur != pw.end())
					cur++;
			}
			else if (L[i] == '-')
			{
				if (cur != pw.begin())
				{
					cur--;
					cur = pw.erase(cur);
				}
			}
			else
			{
				pw.insert(cur, L[i]);
			}
		}

		for (auto c : pw)
			cout << c;

		cout << "\n";
	}

	return 0;
}