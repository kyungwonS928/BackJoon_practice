#include <iostream>
#include <string>
#include <algorithm>
#include <queue>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

queue<pair<int, int>> f;
queue<pair<int, int>> ji;

char arr[1002][1002];
int fire[1002][1002];
int jihun[1002][1002];

int main()
{
	int N, w, h;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		while (!f.empty())
			f.pop();
		while (!ji.empty())
			ji.pop();
		cin >> w >> h;

		for (int i = 0; i < h; i++)
		{
			for (int j = 0; j < w; j++)
			{
				cin >> arr[i][j];
				fire[i][j] = -1;
				jihun[i][j] = -1;

				if (arr[i][j] == '*')
				{
					f.push({i, j});
					fire[i][j] = 0;
				}
				if (arr[i][j] == '@')
				{
					ji.push({i, j});
					jihun[i][j] = 0;
				}
			}
		}

		while (!f.empty())
		{
			pair<int, int> current = f.front();
			f.pop();
			for (int dir = 0; dir < 4; dir++)
			{
				int x = current.first + dx[dir];
				int y = current.second + dy[dir];

				if (x < 0 || x >= h || y < 0 || y >= w)
					continue;
				if (fire[x][y] >= 0 || arr[x][y] == '#')
					continue;
				fire[x][y] = fire[current.first][current.second] + 1;
				f.push({x, y});
			}
		}
		bool success = false;
		while (!ji.empty() && !success)
		{
			pair<int, int> current = ji.front();
			ji.pop();
			for (int dir = 0; dir < 4; dir++)
			{
				int x = current.first + dx[dir];
				int y = current.second + dy[dir];

				if (x < 0 || x >= h || y < 0 || y >= w)
				{
					cout << jihun[current.first][current.second] + 1 << "\n";
					success = true;
					break;
				}
				if (jihun[x][y] >= 0 || arr[x][y] == '#')
					continue;
				if (fire[x][y] != -1 && jihun[current.first][current.second] + 1 >= fire[x][y])
					continue;
				jihun[x][y] = jihun[current.first][current.second] + 1;
				ji.push({x, y});
			}
		}
		if (!success)
			cout << "IMPOSSIBLE\n";
	}
}