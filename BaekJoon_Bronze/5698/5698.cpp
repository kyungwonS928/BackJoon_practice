#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	while (true)
	{
		string str;
		getline(cin, str);

		if (str == "*")
			break;
		stringstream ss(str);
		string word;
		vector<string> words;
		while (ss >> word)
		{
			words.push_back(word);
		}
		char c = tolower(words[0][0]);

		bool flag = true;
		for (string s : words)
		{
			if (tolower(s[0]) != c)
			{
				flag = false;
				break;
			}
		}

		if (flag)
			cout << "Y";
		else
			cout << "N";
	}
}