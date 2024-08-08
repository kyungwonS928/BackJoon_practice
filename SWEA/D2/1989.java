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
          String str = bf.readLine().trim();
            boolean isSame = true;
          for(int i = 0; i < str.length()/2; i++) {
              char ch = str.charAt(i);
              char ch2 = str.charAt(str.length()-i-1);
 
              if(ch != ch2) {
                isSame = false;
                break;
              }
          }
 
          if(isSame) System.out.println("#" + t + " " + 1);
          else System.out.println("#" + t + " " + 0);
 
 
 
        }
    }
}
