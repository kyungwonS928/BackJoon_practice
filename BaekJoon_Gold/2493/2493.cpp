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

	int height[500001] = {
		0,
	};

	stack<int> sta;
	vector<int> result(n, 0);

	for (int i = 0; i < n; i++)
	{
		cin >> height[i];

		while (!sta.empty() && height[sta.top()] < height[i])
			sta.pop();

		if (!sta.empty())
			result[i] = sta.top() + 1;

		sta.push(i);
	}

	for (int i = 0; i < n; i++)
	{
		cout << result[i] << " ";
	}
}