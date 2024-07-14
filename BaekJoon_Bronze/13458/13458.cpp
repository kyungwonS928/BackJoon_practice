#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N, A, B, C;

	cin >> N;

	vector<int> num(N);

	for (int i = 0; i < N; i++)
	{
		cin >> num[i];
	}

	cin >> B >> C;

	long long result = 0;

	for (int i = 0; i < N; i++)
	{
		int student = num[i];

		student -= B;
		result++;

		if (student > 0)
		{
			int a = student / C;
			int b = student % C;

			result += a;
			if (b > 0)
				result++;
		}
	}

	cout << result;

	return 0;
}
