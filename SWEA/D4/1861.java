import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
// 1. 배열의 크기를 입력받는다.
// 2. 방 번호를 입력받는다.
// 3. 배열의 각 점에서 시작한다.
// 3-1. 배열 범위를 벗어나면 재귀를 멈추고 이동횟수를 갱신하고 최댓값을 갱신헀다는 flag를 처리한다.
// 3-2. 자신이 이동하려는 방향의 다음 값이 자신보다 1 더 크면 이동한다.
// 3-3. 갈 수 있는 방이 하나도 없을 때 종료한다.
// 3-4. 모든 탐색을 종료했을 때, 최댓값이 갱신되었으면 출발한 방 번호를 갱신한다.
 
 
public class Solution {
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int board[][];
    static int size;
    static int maxMove;
    static int roomNum;
 
    public static void move(int row, int col, int moveCnt, int startLoc) {
        if (board[row][col] == 0) {
            if(moveCnt == maxMove) {
                roomNum = Math.min(roomNum, startLoc);
            }
            else if (moveCnt > maxMove) {
                maxMove = moveCnt;
                roomNum = startLoc;
            }
            return;
        }
         
        // 위
        if (board[row - 1][col] - board[row][col] == 1) 
             
            move(row - 1, col, moveCnt + 1, startLoc);
        // 오른
        if (board[row][col + 1] - board[row][col] == 1)
            move(row, col + 1, moveCnt + 1,startLoc);
        // 아래
        if (board[row + 1][col] - board[row][col] == 1)
            move(row + 1, col, moveCnt + 1,startLoc);
        // 왼
        if (board[row][col - 1] - board[row][col] == 1)
            move(row, col - 1, moveCnt + 1,startLoc);
         
        //if(board[row][col] == 149) System.out.println("asdf" +maxMove);
        // 갈 수 없음
        if(moveCnt == maxMove) {
            roomNum = Math.min(roomNum, startLoc);
        }
        else if (moveCnt > maxMove) {
            maxMove = moveCnt;
            roomNum = startLoc;
        }
 
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int Test = Integer.parseInt(bf.readLine().trim());
          
        for(int tcase = 1; tcase <= Test; tcase++) {
            //초기화
            maxMove = 1;
            roomNum = 1001;
             
            // 1. 배열의 크기를 입력받는다.
            size = Integer.parseInt(bf.readLine().trim());
            // 2. 방 번호를 입력받는다.
            board = new int[size + 2][size + 2];
     
             
            for(int row = 1; row<size+1; row++) {
                st = new StringTokenizer(bf.readLine().trim());
                for(int col = 1; col<size+1; col++) {
                    board[row][col]= Integer.parseInt(st.nextToken());
                }
            }
             
             
             
             
            for(int row = 1; row<size+1; row++) {
                for(int col = 1; col < size+1; col++) {
                    move(row, col, 1, board[row][col]);
                     
                     
                }
            }
             
             
            System.out.println("#" + tcase + " " + roomNum + " " + maxMove);
        }
          
    }
}