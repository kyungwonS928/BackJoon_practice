#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	vector<int> height(n);
	for (int i = 0; i < n; i++)
	{
		cin >> height[i];
	}

	stack<int> sta;
	long long result = 0;

	for (int i = 0; i < n; i++)
	{

		while (!sta.empty() && height[sta.top()] <= height[i])
		{
			sta.pop();
		}

		result += sta.size();

		sta.push(i);
	}

	cout << result << '\n';
	return 0;
}
