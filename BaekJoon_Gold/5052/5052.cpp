#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int t;
	cin >> t;

	while (t > 0)
	{
		int n;
		cin >> n;
		string phone;
		vector<string> book;
		for (int i = 0; i < n; i++)
		{
			cin >> phone;
			book.push_back(phone);
		}

		sort(book.begin(), book.end());
		bool flag = true;
		for (int i = 0; i < book.size() - 1; i++)
		{

			string prev = book[i];
			string next = book[i + 1];
			flag = true;
			if (prev.length() > next.length())
				continue;
			if (prev == next.substr(0, prev.length()))
			{
				flag = false;
				break;
			}
		}
		if (!flag)
			cout << "NO\n";
		else
			cout << "YES\n";
		t--;
	}

	return 0;
}