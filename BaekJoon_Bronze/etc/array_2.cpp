#include <iostream>
#include <string>
using namespace std;

int func2(int arr[], int N)
{
	int flag = 0;
	int num[101];

	for (int i = 0; i < N; i++)
	{
		if (num[100 - arr[i]] == 1)
		{
			flag = 1;
		}
		num[arr[i]] = 1;
	}
	return flag;
}
