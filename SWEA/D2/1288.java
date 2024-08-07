import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class Solution {
    static BufferedReader bf;
    public static void main(String args[]) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine().trim());
         
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(bf.readLine().trim());
            int num[] = new int[10];
            for(int i = 1; ; i++) {
                 
                int me = N*i;
                while(me > 0) {
                    num[me%10]++;
                    me/=10;
                }
                 
                boolean flag = false;
                for(int j = 0; j<10; j++) {
                    if(num[j] == 0) {
                        flag = true;
                    }
                }
                 
                if(!flag) {
                    System.out.println("#"+t+" " +i*N);
                    break;
                }
            }
             
        }
    }
}
