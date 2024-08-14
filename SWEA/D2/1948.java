import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader bf;
    static StringTokenizer st;
    public static void main(String args[]) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine().trim());
        int day[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int t = 1; t <= T; t++) {
             
            st = new StringTokenizer(bf.readLine().trim());
             
            int f_m = Integer.parseInt(st.nextToken());
            int f_d = Integer.parseInt(st.nextToken());
            int s_m = Integer.parseInt(st.nextToken());
            int s_d = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int i = f_m+1; i<s_m; i++) {
 
                sum += day[i];
            }
             
            if(f_m != s_m) sum += (day[f_m] - f_d +1);
            sum += s_d;
             
            System.out.println("#" + t + " " + sum);
                 
             
             
        }
    }
}
