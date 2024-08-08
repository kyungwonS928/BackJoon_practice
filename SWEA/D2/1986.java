import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader bf;
    static StringTokenizer st;
 
 
 
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(bf.readLine().trim());
 
        for(int t = 1; t <= T; t++) {
           int N = Integer.parseInt(bf.readLine().trim());
           int result = 0;
           for(int i = 1; i <= N; i++) {
               if(i % 2 == 0) {
                   result -= i;
               } else {
                   result += i;
               }
           }
 
            System.out.println("#" + t + " " + result);
        }
    }
}
