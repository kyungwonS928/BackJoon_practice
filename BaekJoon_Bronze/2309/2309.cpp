#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main()
{

	vector<int> nan(9,0);
	int sum = 0;
	for (int i = 0; i < 9; i++) {
		cin >> nan[i];
		sum += nan[i];
	}

	sort(nan.begin(), nan.end());

	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 9; j++) {
			if (sum - nan[i] - nan[j] == 100) {
				for (int k = 0; k < 9; k++) {
					if (k != i && k != j) cout << nan[k] << '\n';
					
				}
				return 0;
			}
		}
	}
}
