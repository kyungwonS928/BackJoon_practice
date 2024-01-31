#include<iostream>
#include<string>
using namespace std;


int main() {
    int step[8][2] = {{2, 1}, {2, -1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {1, -2}, {-1, -2}};
    int cnt = 0;
    string location;
    cin >> location;

    int row = static_cast<int>(location[0])-96;
    int col = static_cast<int>(location[1])-48;

    for(int i = 0; i < 8; i++) {
        int next_row = row + step[i][0];
        int next_col = col + step[i][1];
        

        if(next_row >= 1 && next_row <= 8 && next_col >= 1 && next_row <= 8) cnt ++;
    }
    cout << cnt;
    return 0;
}