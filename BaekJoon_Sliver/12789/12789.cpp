#include <bits/stdc++.h>
using namespace std;

int main(void)
{

	int N;
	cin >> N;

	stack<int> order;
	queue<int> student;

	for (int i = 1; i <= N; i++)
	{
		int n;
		cin >> n;
		student.push(n);
	}

	int flag = 1;
	while (!student.empty())
	{
		int now = student.front();
		student.pop();
		if (flag == now)
		{
			flag++;
			continue;
		}
		else
		{
			if (!order.empty() && order.top() < now)
			{
				cout << "Sad";
				return 0;
			}
			order.push(now);
		}
	}

	while (!order.empty() && order.top() == flag)
	{
		flag++;
		order.pop();
	}

	if (flag == N + 1)
	{
		cout << "Nice";
	}
	else
	{
		cout << "Sad";
	}
}