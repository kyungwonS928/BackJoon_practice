#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	vector<int> arr(3);

	cin >> arr[0] >> arr[1] >> arr[2];

	sort(arr.begin(), arr.end());

	cout << arr[0] << arr[1] << arr[2];
}