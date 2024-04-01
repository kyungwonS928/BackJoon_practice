#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int cnt[100001] = {
	0,
};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N, K;
	cin >> N >> K;
	vector<int> num;
	for (int i = 0; i < N; i++)
	{
		int n;
		cin >> n;
		num.push_back(n);
	}

	int max_val = 0;

	int left = 0;
	int right = 0;

	while (right < N)
	{
		if (cnt[num[right]] < K)
		{
			cnt[num[right]]++;
			right++;
		}
		else
		{
			cnt[num[left]]--;
			left++;
		}

		max_val = max(max_val, right - left);
	}

	cout << max_val;

	return 0;
}