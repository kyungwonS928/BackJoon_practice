#include<iostream>
#include<string>
using namespace std;


int x, y, d;

int turn_left(int now) {
    int left = 0;
    switch(now) {
        case 0: left = 3; break;
        case 1: left = 0; break;
        case 2: left = 1; break;
        case 3: left = 2; break;
        default: break;
    }
    return left;
}


int main() {
    int N, M;
    cin>>N>>M;

    cin >> x >> y >> d;

    int** game = new int *[N];

    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};

    for (int i = 0; i < N; ++i) {
    game[i] = new int[M];
}

    //입력
    for(int i =0; i< N; i++){
        for(int j = 0; j< M; j++) {
            cin >> game[i][j];
        }
    }
    
    int turn = 0;

    int cnt = 1;;

    while(true) {
        
        d = turn_left(d);
        if(game[x+dx[d]][y+dy[d]] == 0) {
            game[x][y] = 1;
            x = x+dx[d];
            y = y+dy[d];
            cnt++;
            turn = 0;
            
            
        } else {
            turn++;
        }
        
        if(turn == 4) {
            if(game[x-dx[d]][y-dy[d]] == 0) {
                x = x-dx[d];
                y = y-dy[d];
            } else {break;}
            turn = 0;
            
        }


    }

    cout << cnt;

for (int i = 0; i < N; ++i) {
        delete[] game[i];
    }
    delete[] game;

    
    return 0;
}