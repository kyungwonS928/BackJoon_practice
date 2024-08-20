
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader bf;
    static StringTokenizer st;
    static int cnt;
    static int operand[];
    static int operator[];
    static char selected[];
    static int minResult;
    static int maxResult;
 
    public static void calculator() {
 
        int result = operand[0];
        for(int idx = 0; idx < cnt-1; idx++) {
            if(selected[idx] == '+') {
                result += operand[idx+1];
            } else if(selected[idx] == '-') {
                result -= operand[idx+1];
            } else if(selected[idx] == '*') {
                result *= operand[idx+1];
            } else if(selected[idx] == '/') {
                result /= operand[idx+1];
            }
        }
 
        if(maxResult < result) maxResult = result;
        if(minResult > result) minResult = result;
    }
 
    public static void permutation(int selectIdx) {
        if(selectIdx == (cnt-1)) {
            calculator();
            return;
        }
 
        if(operator[0]-1 >= 0) {
            selected[selectIdx] = '+';
            operator[0]--;
            permutation(selectIdx+1);
            operator[0]++;
        }
 
        if(operator[1] -1 >= 0) {
            selected[selectIdx] = '-';
            operator[1]--;
            permutation(selectIdx+1);
            operator[1]++;
        }
 
        if(operator[2] -1 >= 0) {
            selected[selectIdx] = '*';
            operator[2]--;
            permutation(selectIdx+1);
            operator[2]++;
        }
 
        if(operator[3] -1 >= 0) {
            selected[selectIdx] = '/';
            operator[3]--;
            permutation(selectIdx+1);
            operator[3]++;
        }
 
 
 
 
    }
 
    public static void main(String args[]) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        int Test = Integer.parseInt(bf.readLine().trim());
        for(int tcase = 1; tcase <= Test; tcase++) {
            //초기화
            minResult = 100000000;
            maxResult = -100000000;
 
            cnt = Integer.parseInt(bf.readLine().trim());
            operand = new int[cnt];
            operator = new int[4];
            selected = new char[cnt-1];
 
            st = new StringTokenizer(bf.readLine().trim());
            for(int idx = 0; idx<4; idx++) {
                operator[idx] = Integer.parseInt(st.nextToken());
            }
 
            st = new StringTokenizer(bf.readLine().trim());
            for(int idx = 0; idx<cnt; idx++) {
                operand[idx] = Integer.parseInt(st.nextToken());
            }
 
            permutation(0);
            System.out.println("#" + tcase + " " + (maxResult - minResult));
        }
    }
 
}
