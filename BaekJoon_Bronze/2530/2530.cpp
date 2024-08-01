#include<iostream>
#include<vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int h, m, s;
	cin >> h >> m >> s;

	int time;
	cin >> time;

	m += time / 60;

	s += time % 60;

	if (s >= 60) {
		m += s / 60;
		s = s % 60;
	}

	if (m >= 60) {
		h += m / 60;
		m = m % 60;
	}

	if (h >= 24) {
		h %= 24;
	}

	cout << h << " " << m << " " << s << '\n';

}
