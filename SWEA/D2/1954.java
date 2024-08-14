import java.io.BufferedReader;
 
// 달팽이 숫자 - 재귀로 풀기
// 1. 테스트 케이스를 입력받는다
// 2. 배열의 크기를 입력받는다
// 3. 재귀함수를 호출한다
// 3-1. 들어가야하는 값이 N^2 보다 크면 재귀를 멈춘다
// 3-2. 배열에 값을 입력한다
// 3-3. 다음으로 값이 들어갈 row와 col을 값을 구한다
// 3-4. 다음 row와 col이 벽을 만나거나 그 위치에 이미 값이 있으면 방향을 바꾼다
// 3-5. 바꾼 방향에 대해서 다시 위치를 구한다
// 3-6. 다음 재귀를 호출한다
 
 
 
 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader bf;
    static StringTokenizer st;
    static int input;
    static final int dx[] = {0, 1, 0, -1};
    static final int dy[] = {1, 0, -1, 0};
    static int[][] snail;
    static int index;
     
     
    public static void recursive(int s_row, int s_col, int dir) {
         
         
        // 3-1. 들어가야하는 값이 N^2 보다 크면 재귀를 멈춘다
        if(index > Math.pow(input, 2)) {
             
            return;
        }
         
         
        // 3-2. 배열에 값을 입력한다 
        snail[s_row][s_col] = index++;
         
        // 3-3. 다음으로 값이 들어갈 row와 col을 값을 구한다
        int new_row = s_row + dx[dir];
        int new_col = s_col + dy[dir];
         
        // 3-4. 다음 row와 col이 벽을 만나거나 그 위치에 이미 값이 있으면 방향을 바꾼다
        if(new_row < 0 || new_row >= input || new_col < 0 || new_col >= input || snail[new_row][new_col] !=0) {
            dir = (dir+1) %4;
            // 3-5. 바꾼 방향에 대해서 다시 위치를 구한다
            new_row = s_row + dx[dir];
            new_col = s_col + dy[dir];
        } 
 
        // 3-6. 다음 재귀를 호출한다
        recursive(new_row, new_col, dir);
         
    }
     
     
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        bf = new BufferedReader(new InputStreamReader(System.in));
         
         int Test = Integer.parseInt(bf.readLine().trim());
         for(int tcase = 1; tcase<=Test; tcase++) {
              
             index= 1;
             for(int row = 0; row<input; row++) {
                 for(int col = 0; col<input; col++) {
                     snail[row][col] =0;
                 }
             }
              
             input = Integer.parseInt(bf.readLine().trim());
             snail = new int[input][input];
              
             recursive(0, 0, 0);
              
             System.out.println("#" + tcase);
             for(int row = 0; row<input; row++) {
                 for(int col = 0; col<input; col++) {
                     System.out.print(snail[row][col] + " ");
                 }
                 System.out.println();
             }
              
         }
    }
}
