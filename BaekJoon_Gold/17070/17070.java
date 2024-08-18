
//1. 격자판의 크기를 입력받는다
//2. 파이프는 가로, 세로 또는 오른쪽으로 회전한 대각선 방향으로 이동할 수 있다
//2-1. 파이프는 2칸을 차지하며, 머리칸과 꼬리칸이 모두 한칸이 이동한다
//3. 둘째줄부터 격자판 배열을 입력받는다
//3-1. 벽은 1로 주어진다
//3-2. 처음 파이프는 1,1, 2,2 를 차지하고 있다
//3-3. (1, 1)과 (1, 2)는 항상 빈칸이다
//4. 파이프의 판쪽 끝을 N,N으로 이동시키는 방법의 수를 출력한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static int size;
    static int map[][];
    static int dp[][][];
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int totalMove;



    public static void dfs(int x, int y, int dir) {

        if(x >= size ||y >= size||map[x][y]== 1) return;

        if(dir == 2 && (map[x-1][y] == 1 || map[x][y-1]==1)) return;

        if(x == size-1 && y == size-1) {
            totalMove++;
            return;
        }


        //파이프가 가로일때
        if(dir ==0 ){
            dfs(x, y+1, 0);
            dfs(x+1, y+1,2);
        }
        //세로일때
        else if(dir ==1){
            dfs(x+1, y, 1);
            dfs(x+1, y+1,2);
        }
        //대각선으로 놓여있을 때
        else {
            dfs(x, y+1,  0);
            dfs(x+1, y, 1);
            dfs(x+1, y+1, 2);
        }


    }

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));


        st = new StringTokenizer(bf.readLine().trim());
        size = Integer.parseInt(st.nextToken());
        map = new int[size][size];
        dp = new int[size][size][3];
        for(int row = 0; row < size; row++) {
            st = new StringTokenizer(bf.readLine().trim());
            for(int col = 0; col < size; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,1,0);

//        dp[0][1][0] = 1;
//
//        for(int row = 0; row < size; row++) {
//            for(int col = 0; col < size; col++) {
//                if(map[row][col] == 1) continue;
//
//                //가로일때
//                if(col > 0) {
//                    dp[row][col][0] += dp[row][col-1][0];
//                    dp[row][col][0] += dp[row][col-1][2];
//                }
//
//
//                //세로일때
//                if(row >0) {
//                    dp[row][col][1] += dp[row-1][col][1];
//                    dp[row][col][1] += dp[row-1][col][2];
//                }
//
//
//                //대각선일때
//                if(row >0 && col >0 &&map[row][col-1] == 0 && map[row-1][col] == 0) {
//                    dp[row][col][2] += dp[row-1][col-1][0];
//                    dp[row][col][2] += dp[row-1][col-1][1];
//                    dp[row][col][2] += dp[row-1][col-1][2];
//                }
//
//            }
//        }
//
//
//        totalMove = dp[size-1][size-1][0]+dp[size-1][size-1][1] + dp[size-1][size-1][2];
        System.out.println(totalMove);

    }
}

