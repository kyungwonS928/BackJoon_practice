#include <bits/stdc++.h>
using namespace std;

bool compare(tuple<int, int, int> i, tuple<int, int, int> j)
{
	int first = get<2>(i);
	int second = get<2>(j);

	if (first > second)
		return true;
	return false;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N;

	cin >> N;

	vector<tuple<int, int, int>> score;

	for (int i = 0; i < N; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		score.push_back({a, b, c});
	}

	sort(score.begin(), score.end(), compare);

	int first = get<0>(score[0]), second = get<0>(score[1]);
	int idx = 2;

	if (first == second)
	{
		for (int i = 2; i < N; i++)
		{
			int third = get<0>(score[i]);
			if (third != first)
			{
				idx = i;
				break;
			}
		}
	}

	cout << get<0>(score[0]) << " " << get<1>(score[0]) << '\n';
	cout << get<0>(score[1]) << " " << get<1>(score[1]) << '\n';
	cout << get<0>(score[idx]) << " " << get<1>(score[idx]) << '\n';
}