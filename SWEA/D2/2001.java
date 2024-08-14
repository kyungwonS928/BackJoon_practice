import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
 
// 1. 배열의 크기와 한번에 구간합을 구할 크기를 입력받는다
// 2. N*N 크기 배열에 들어갈 수를 입력받는다
// 3. 배열을 입력받으면서 누적합을 구한다
// 3-1. 2차원 배열에서의 누적합은 num[row][col-1] + num[row-1][col] + element - num[row-1][col-1]이다
// 4. 전체 배열을 돌며 해당 구간의 구간합을 구하고 최댓값을 업데이트 한다
// 5. 구하고자 하는 구간의 크기가 M * M 이므로 
// 5-1. 해당 구간에 대한 누적합은 num[end_row][end_col] - num[start_row-M][end_col] - num[end_row][start_col-M] + num[start_row-M-1][start_col-M-1]이다
 
public class Solution {
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int cnt;
    static int size;
    static int num[][];
    static int max_val;
 
    public static void main(String[] args) throws NoSuchElementException, IOException {
        // TODO Auto-generated method stub
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
         
        int Test = Integer.parseInt(bf.readLine().trim());
        for(int tcase = 1; tcase <= Test; tcase++) {
            // 1. 배열의 크기와 한번에 구간합을 구할 크기를 입력받는다
            st = new StringTokenizer(bf.readLine().trim());
            cnt = Integer.parseInt(st.nextToken());
            size = Integer.parseInt(st.nextToken());
            // 2. N*N 크기 배열에 들어갈 수를 입력받는다
            num = new int[cnt+1][cnt+1];
            // 3. 배열을 입력받으면서 누적합을 구한다
            // 3-1. 2차원 배열에서의 누적합은 num[row][col-1] + num[row-1][col] + element - num[row-1][col-1]이다
            for(int row = 1; row<cnt+1; row++) {
                st = new StringTokenizer(bf.readLine().trim());
                for(int col = 1; col < cnt+1; col++) {
                    int element = Integer.parseInt(st.nextToken());
                    num[row][col] = num[row-1][col] + num[row][col-1] + element - num[row-1][col-1];
                }
            }
             
            max_val = 0;
                 
            // 4. 전체 배열을 돌며 해당 구간의 구간합을 구하고 최소값을 업데이트 한다        
            for(int row = size; row<cnt+1; row++) {
                for(int col = size; col < cnt+1; col++) {
                    // 5. 구하고자 하는 구간의 크기가 M * M 이므로 
                    // 5-1. 해당 구간에 대한 누적합은 num[end_row][end_col] - num[start_row-M][end_col] - num[end_row][start_col-M] + num[start_row-M-1][start_col-M-1]이다
                    int area_sum = num[row][col] - num[row-size][col] - num[row][col-size] + num[row-size][col-size];
                    max_val = Math.max(max_val, area_sum);
                }
            }
            System.out.println("#" + tcase + " " + max_val);
        }
    }
}
