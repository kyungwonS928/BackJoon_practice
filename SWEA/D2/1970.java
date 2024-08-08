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
            int money = Integer.parseInt(bf.readLine().trim());
 
            System.out.println(
                    "#" + t + "\n" +
                            money / 50000 + " " +
                            (money %50000) / 10000 + " " +
                            ((money %50000) % 10000 ) /5000 + " " +
                            (((money %50000) % 10000 )  % 5000) / 1000 + " " +
                            ((((money %50000) % 10000 )  % 5000) % 1000) / 500 + " " +
                            (((((money %50000) % 10000 )  % 5000) % 1000) % 500) / 100 + " " +
                            ((((((money %50000) % 10000 )  % 5000) % 1000) % 500) % 100 ) / 50 + " " +
                            (((((((money %50000) % 10000 )  % 5000) % 1000) % 500) % 100 )% 50 ) /10
 
            );
 
        }
    }
}
