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

	stack<int> sta;
	int num;
	vector<char> arr;

	int pushnum = 1;
	bool flag = true;

	for (int i = 0; i < n; i++)
	{
		cin >> num;

		if (!sta.empty())
		{
			if (sta.top() == num)
			{
				sta.pop();
				arr.push_back('-');
				continue;
			}
			else if (sta.top() > num)
			{
				flag = false;
				break;
			}
		}

		for (int j = pushnum; j <= num; j++)
		{
			pushnum++;
			sta.push(j);
			arr.push_back('+');
		}
		arr.push_back('-');
		sta.pop();
	}

	if (flag)
	{
		for (char v : arr)
		{
			cout << v << '\n';
		}
	}
	else
	{
		cout << "NO";
	}
}