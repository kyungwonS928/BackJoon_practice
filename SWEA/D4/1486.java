import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
// 1. 점원 수와 기준 키를 입력받는다
// 2. 점원들의 키를 입력받는다.
// 3. 점원들의 키에 대한 부분집합을 만든다.
// 3-1. 
 
 
public class Solution {
 
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int people;
    static int criteria;
    static int height[];
    static int minHeight;
     
     
 
    public static void powerSet(int elementIdx, int sum) {
        if(elementIdx == people) {
            //System.out.println("sum" + sum);
            if(minHeight > sum && sum >= criteria) minHeight = sum;
            return;
        }
         
        powerSet(elementIdx + 1, sum + height[elementIdx]);
        powerSet(elementIdx + 1, sum);
    }
 
     
    public static void main(String args[]) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
 
        int Test = Integer.parseInt(bf.readLine().trim());
 
        for (int tcase = 1; tcase <= Test; tcase++) {
             
            minHeight = 987654321;
            st = new StringTokenizer(bf.readLine().trim());
             
            people = Integer.parseInt(st.nextToken());
            criteria = Integer.parseInt(st.nextToken());
             
             
            height = new int[people];
             
            st = new StringTokenizer(bf.readLine().trim());
            for(int idx = 0; idx<people; idx++) {
                height[idx] = Integer.parseInt(st.nextToken());
            }
             
             
            powerSet(0, 0);
            //System.out.println("min" + minHeight);
            System.out.println("#" + tcase + " " + (minHeight - criteria));
             
        }
 
    }
 
}
