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
          st = new StringTokenizer(bf.readLine().trim());
 
          int P = Integer.parseInt(st.nextToken());
          int Q = Integer.parseInt(st.nextToken());
          int R = Integer.parseInt(st.nextToken());
          int S = Integer.parseInt(st.nextToken());
          int W = Integer.parseInt(st.nextToken());
 
          int A = W*P;
          int B = 0;
          if (W < R) B = Q;
          else B = Q + (W - R) * S;
 
          if(A>B) System.out.println("#" + t + " " + B);
          else System.out.println("#" + t + " " + A);
 
        }
    }
}
