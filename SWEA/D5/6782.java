import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
// 1. N을 입력받는다.
// 2. N을 2로 만든다
// 2-1. 루트 N이 정수라면, 루트 N으로 변경하여 다음 과정을 진행한다. (조작 +1)
//      루트 N을 다시 제곱한 값과, N이 같다면 루트 N이 정수이다.
// 2-2. 아니라면, N+1을 하고 다음 과정을 진행한다.(조작+1)
// 2-3. 2가 되면 재귀를 끝낸다.
// 3. 조작한 횟수를 출력한다
 
 
public class Solution {
 
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static long input;
    static long operationCnt;
     
    public static void operate(long num) {
        if(num == 2) return;
         
        if((long) Math.pow((long) Math.sqrt(num), 2) == num) {
            operationCnt++;
            operate((long) Math.sqrt(num));
        } else {
 
            long next = (long) Math.pow((long) Math.sqrt(num) +1, 2);
            long diff = next - num;
            operationCnt += diff;
            operate(next);
        }
    }
     
    public static void main(String args[]) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        int Test = Integer.parseInt(bf.readLine().trim());
 
        for (int tcase = 1; tcase <= Test; tcase++) {
            operationCnt = 0;
            input = Long.parseLong(bf.readLine().trim());
             
            operate(input);
             
            sb.append("#" + tcase + " " + operationCnt +'\n');
             
        }
         
        System.out.println(sb.toString());
 
    }
 
}
