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
            List<Integer> list = new ArrayList<Integer>();
 
            int N = Integer.parseInt(bf.readLine().trim());
            st = new StringTokenizer(bf.readLine().trim());
            for(int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
 
            Collections.sort(list);
            System.out.printf("#" + t + " ");
            for(int i = 0; i < N; i++) {
                System.out.printf(list.get(i) + " ");
            }
            System.out.println();
 
        }
    }
}
