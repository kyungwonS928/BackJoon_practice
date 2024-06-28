#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int A, B, C;
	cin >> A >> B >> C;

	cout << A + B - C << '\n';

	string strA = to_string(A);
	string strB = to_string(B);
	int result_str = stoi(strA + strB);
	cout << result_str - C << '\n';
}