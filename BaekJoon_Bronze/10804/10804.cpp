#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main()
{
	int num[20] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

	
	for (int j = 0; j < 10; j++) {
		int x, y;
		cin >> x >> y;

		for (int i = 0; i < (y - x +1) / 2; i++) {
			int temp = num[x+i-1];
			num[x + i - 1] = num[y - i - 1];
			num[y - i - 1] = temp;
		}

	}

	for (int i = 0; i < 20; i++) {
		cout << num[i] << " ";
	}
	return 0;
	
}
