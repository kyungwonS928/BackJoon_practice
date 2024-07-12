#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	string str;
	getline(cin, str);

	int feeling[2] = {0, };

	for (int i = 0; i < str.length(); i++) {
		if (i > 1 && str[i - 1] == '-' && str[i - 2] == ':') {
			if (str[i] == ')') {
				feeling[0]++;
			}
			else if (str[i] == '(') {
				feeling[1]++;
			}
		}
	}

	if (feeling[0] > feeling[1]) cout << "happy";
	else if(feeling[0] < feeling[1]) cout << "sad";
	else if (feeling[0] == 0 || feeling[0] == 0) cout << "none";
	else if (feeling[0] == feeling[1]) cout << "unsure";

}
