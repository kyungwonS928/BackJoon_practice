#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll mod(ll a, ll b, ll c)
{
	if (b == 1)
		return a % c;

	ll val = mod(a, b / 2, c);
	val = val * val % c;
	if (b % 2 == 0)
		return val;
	return val * a % c;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	ll A, B, C;
	cin >> A >> B >> C;

	cout << mod(A, B, C);
}