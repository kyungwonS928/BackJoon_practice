#include <iostream>
using namespace std;

char board[52][52];

int main() {

	int N, M;
	cin >> N >> M;


	int car = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
		}
	}

	int result[5] = { 0, };
	for (int i = 0; i < N - 1; i++) {
		for (int j = 0; j < M - 1; j++) {
			int temp = 0;
			if (board[i][j] == '#' || board[i + 1][j] == '#' || board[i][j + 1] == '#' || board[i + 1][j + 1] =='#' ) {
				continue;
			}

			if (board[i][j] == 'X') temp++;
			if (board[i+1][j] == 'X') temp++;
			if (board[i][j+1] == 'X') temp++;
			if (board[i+1][j+1] == 'X') temp++;

			result[temp]++;
		}
	} 
	
	for (int i = 0; i < 5; i++) {
		cout << result[i] << '\n';
	}

	return 0;
}
