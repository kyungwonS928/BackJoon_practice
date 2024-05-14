#include <iostream>
#include <string>
using namespace std;

int main()
{

	string plain;
	string cipher;
	getline(cin, plain);
	getline(cin, cipher);

	string result;

	for (int i = 0, j = 0; i < plain.length(); i++, j++)

	{
		if (j == cipher.length())
			j = 0;
		if (plain[i] == ' ')
		{
			result += ' ';
			continue;
		}
		if (plain[i] > cipher[j])
		{
			result += (char)(plain[i] - cipher[j]) + 96;
		}
		else
		{
			result += (char)122 - (cipher[j] - plain[i]);
		}
	}

	cout << result;
}
