import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
// 회사에서 출발해 모든 고객을 들러 집으로 도착하는 경로
// 1. 고객의 수를 입력받는다
// 2. 회사 좌표, 집 좌표, 고객의 집 좌표를 입력받는다
// 3. 고객의 집에 대한 순열을 구한다.
// 4. 모든 집의 순서를 배열하면 회사부터, 고객의 집, 자신의 집 순서로 경로 길이 값을 구한다.
// 5. 최소 경로를 출력한다.
 
public class Solution {
 
    static BufferedReader bf;
    static StringTokenizer st;
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x =x ;
            this.y = y ;
        }
    }
    static int num;
    static Pair company;
    static Pair house;
    static Pair customer[];
    static boolean visit[];
    static int orderCus[];
    static int minDistance;
 
    public static void calculator() {
        int distance = 0;
        for(int idx = 0; idx < num; idx++) {
            if(idx == 0) {
                distance+= Math.abs(company.x - customer[orderCus[idx]].x) + Math.abs(company.y - customer[orderCus[idx]].y);
            } else {
                distance += Math.abs(customer[orderCus[idx]].x - customer[orderCus[idx-1]].x) + Math.abs(customer[orderCus[idx]].y - customer[orderCus[idx-1]].y);
                if(idx == num-1) {
                    distance+= Math.abs(house.x - customer[orderCus[idx]].x) + Math.abs(house.y - customer[orderCus[idx]].y);
                }
            }
 
            if(minDistance < distance) return;
        }
 
        minDistance = distance;
    }
 
    public static void permutation(int selectIdx) {
        if(selectIdx == num) {
            calculator();
            return;
        }
 
        for(int elementIdx = 0; elementIdx < num; elementIdx++) {
            if(visit[elementIdx]) continue;
 
            visit[elementIdx] = true;
            orderCus[selectIdx] = elementIdx;
            permutation(selectIdx + 1);
            visit[elementIdx] = false;
        }
    }
 
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
 
        int Test = Integer.parseInt(bf.readLine().trim());
 
        for(int tcase = 1; tcase <= Test; tcase++) {
            minDistance = Integer.MAX_VALUE;
 
 
            num = Integer.parseInt(bf.readLine().trim());
 
            customer = new Pair[num];
            visit = new boolean[num];
            orderCus = new int[num];
 
            st = new StringTokenizer(bf.readLine().trim());
            company = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            house = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int idx = 0; idx < num; idx++) {
                customer[idx] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
 
            permutation(0);
 
            System.out.println("#" + tcase + " " + minDistance);
        }
 
 
    }
}