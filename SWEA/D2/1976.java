import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader bf;
    static StringTokenizer st;
 
 
 
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(bf.readLine().trim());
 
 
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(bf.readLine().trim());
            int f_h = Integer.parseInt(st.nextToken());
            int f_m = Integer.parseInt(st.nextToken());
            int s_h = Integer.parseInt(st.nextToken());
            int s_m = Integer.parseInt(st.nextToken());
 
            int sum_h = f_h + s_h;
            int sum_m = f_m + s_m;
 
            int min = sum_m % 60;
            sum_m /= 60;
 
            int hour = sum_h + sum_m;
            hour %= 12;
             
            if(hour == 0) hour = 12;
 
            System.out.println("#" + t + " " + hour + " " + min);
 
 
        }
    }
}
