#include <iostream>
#include <vector>
using namespace std;

int N, S;
int set[20];
int check[20];
int result = 0;

void powerSet(int elementIdx, int sum)
{
	if (elementIdx == N)
	{
		if (sum == S)
			result++;
		return;
	}

	powerSet(elementIdx + 1, sum + set[elementIdx]);

	check[elementIdx] = false;
	powerSet(elementIdx + 1, sum);
}

int main()
{
	cin >> N >> S;
	for (int i = 0; i < N; i++)
	{
		cin >> set[i];
	}
	powerSet(0, 0);

	if (S == 0)
		result--;

	cout << result;

	return 0;
}
