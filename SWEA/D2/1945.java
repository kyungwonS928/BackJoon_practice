import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    static BufferedReader bf;
    public static void main(String args[]) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine().trim());
         
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(bf.readLine().trim());
            int a=0, b=0, c=0, d =0, e = 0;
            while(N > 1) {
                 
                if(N%11 == 0) {
                    N/=11;
                    e++;
                }
                 
                if(N%7 == 0) {
                    N/=7;
                    d++;
                }
                 
                if(N%5 == 0) {
                    N/= 5;
                    c++;
                }
                 
                if(N%3 == 0) {
                    N/=3;
                    b++;
                }
                 
                if(N%2 == 0) {
                    N/=2;
                    a++;
                }
                 
            }
             
            System.out.println("#" + t + " "+ a+ " "+ b + " "+ c + " "+ d + " "+ e + " ");
        }
    }
}
