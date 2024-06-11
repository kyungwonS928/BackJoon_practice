#include <iostream>
#include <stack>
using namespace std;

int main()
{

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int K, N;
	cin >> K;

	unsigned int result = 0;
	stack<int> sta;

	while (K--)
	{
		cin >> N;
		if (N == 0)
		{
			sta.pop();
		}
		else
		{
			sta.push(N);
		}
	}
	int size = sta.size();
	for (int i = 0; i < size; i++)
	{
		result += sta.top();
		sta.pop();
	}

	cout << result;
}