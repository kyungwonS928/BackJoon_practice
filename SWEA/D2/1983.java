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
        String[] record = {"A+", "A0", "A-", "B+", "B0",  "B-" , "C+", "C0", "C-", "D0"} ;
        for(int t = 1; t <= T; t++) {
            List<Double> list = new ArrayList<>();
            st = new StringTokenizer(bf.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
 
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine().trim());
                int mid = Integer.parseInt(st.nextToken());
                int fin = Integer.parseInt(st.nextToken());
                int ass =  Integer.parseInt(st.nextToken());
 
                double score = mid * 0.35 + fin * 0.45 + ass*0.2;
 
                list.add(score);
            }
            double score_k = list.get(K-1);
            Collections.sort(list, Collections.reverseOrder());
 
            System.out.println("#" + t + " " + record[list.indexOf(score_k)/(N/10)]);
 
 
        }
    }
}
