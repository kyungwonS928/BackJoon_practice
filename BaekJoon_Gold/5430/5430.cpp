#include <bits/stdc++.h>
using namespace std;

deque<int> deq;

int main()
{

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;

	string s;
	int num;
	string k;

	while (T--)
	{

		deq.clear();
		cin >> s >> num >> k;

		k = k.substr(1, k.length() - 2);
		stringstream ss(k);
		string temp;
		while (getline(ss, temp, ','))
		{
			if (!temp.empty())
			{
				deq.push_back(stoi(temp));
			}
		}

		bool error = false;
		bool reverse = false;
		for (int i = 0; i < s.length(); i++)
		{
			if (s[i] == 'R')
			{
				reverse = !reverse;
			}
			else if (s[i] == 'D')
			{
				if (deq.empty())
				{
					error = !error;
					break;
				}
				else
				{
					if (reverse)
						deq.pop_back();
					else
						deq.pop_front();
				}
			}
		}

		if (error)
		{
			cout << "error" << '\n';
		}
		else
		{

			cout << "[";
			if (reverse)
			{
				for (auto it = deq.rbegin(); it != deq.rend(); ++it)
				{
					cout << *it;
					if (it + 1 != deq.rend())
						cout << ",";
				}
			}
			else
			{
				for (auto it = deq.begin(); it != deq.end(); ++it)
				{
					cout << *it;
					if (it + 1 != deq.end())
						cout << ",";
				}
			}

			cout << "]" << '\n';
		}
	}
}
