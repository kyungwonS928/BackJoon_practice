#include <bits/stdc++.h>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;

	string a = "";
	string b = "";

	for (int i = 0; i < N; i++)
	{
		string str;
		cin >> str;
		a += str;
	}

	for (int i = 0; i < N; i++)
	{
		string str;
		cin >> str;
		b += str;
	}

	long long a_sum = stoll(a);
	long long b_sum = stoll(b);

	cout << min(a_sum, b_sum);

	return 0;
}
