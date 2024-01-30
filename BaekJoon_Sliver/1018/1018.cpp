#include<iostream>
#include<string>
#include <algorithm>
using namespace std;

string WB[8] = {
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW"
};
string BW[8] = {
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB"
};

int cntWB(string board[50],int x, int y) {
    int cnt = 0;
    for(int i = 0; i < 8; i++)
    {
        for(int j = 0; j < 8; j++)
        {
            if(board[x+i][y+j] != WB[i][j])
                cnt++;
        }

    }
    return cnt;
}

int cntBW(string board[50],int x, int y) {
    int cnt = 0;
    for(int i = 0; i < 8; i++)
    {
        for(int j = 0; j < 8; j++)
        {
            if(board[x+i][y+j] != BW[i][j])
                cnt++;
        }

    }
    return cnt;
}

int main() {
    string chess[50];

    int N, M;
    cin >> N >> M;
    int min_val =64;

    for(int i = 0; i < N; i++) {
        cin>> chess[i];
    }

    for(int i = 0; i+8<=N;i++) {
        for(int j = 0;j+8<=M; j++) {
            int temp = 0;
            temp = std::min(cntWB(chess, i, j), cntBW(chess, i, j));
            if(temp < min_val) min_val = temp;
        }
    }

    cout << min_val;
    return 0;
}