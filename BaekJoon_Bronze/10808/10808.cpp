#include <iostream>
#include <string>
using namespace std;

int main()
{
	string S;
	cin >> S;

	int alpha[26] = {
		0,
	};

	for (int i = 0; i < S.length(); i++)
	{
		alpha[S[i] - 'a']++;
	}

	for (int i = 0; i < 26; i++)
	{
		cout << alpha[i] << " ";
	}
}