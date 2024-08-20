import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
// 1. 농장의 크기가 주어진다
// 2. 농작물의 가치가 주어진다(2차원 배열)
// 3. 마름모 모양에 포함되어있는 농작물의 가치를 계산한다.
// 3-1. 마름모의 내부에 포함되는 좌표들은 모두 마름모의 중심 좌표와의 차이가 농장의 크기/2보다 작거나 같다.
 
public class Solution {
 
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int size;
    static int farm[][];
    static int value;
     
    public static void sumValue() {
        for(int row = 0; row<size; row++) {
            for(int col = 0; col<size; col++) {
                // 3-1. 마름모의 내부에 포함되는 좌표들은 모두 마름모의 중심 좌표와의 차이가 농장의 크기/2보다 작거나 같다.
                if(Math.abs(row - size/2) + Math.abs(col - size/2) <= size/2) {
                    value+= farm[row][col];
                }
            }
        }
    }
     
    public static void main(String args[]) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
         
        int Test= Integer.parseInt(bf.readLine().trim());
         
        for(int tcase = 1; tcase <= Test; tcase++) {
            //초기화
            value = 0;
             
            // 1. 농장의 크기가 주어진다
            size = Integer.parseInt(bf.readLine().trim());
             
            // 2. 농작물의 가치가 주어진다(2차원 배열)
            farm = new int[size][size];
            for(int row = 0; row<size; row++) {
                String line = bf.readLine().trim();
                for(int col = 0; col <size; col++) {
                    farm[row][col] = line.charAt(col) - '0';
                }
            }
            // 3. 마름모 모양에 포함되어있는 농작물의 가치를 계산한다.
            sumValue();
             
            System.out.println("#" + tcase + " " + value);
        }
         
         
    }
     
     
 
}
