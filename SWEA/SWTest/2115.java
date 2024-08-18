import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution
{
    static BufferedReader bf;
    static StringTokenizer st;
    static int size;
    static int basket;
    static int limit;
    static int map[][];
    static int firstBasket[];
    static boolean usedFirst[];
    static int secondBasket[];
    static boolean usedSecond[];
    static class Pair {
        int x;
        int y;
 
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int totalProfit;
    static int maxFirst;
    static int maxSecond;
 
    public static void calculate(int num) {
        if(num == 1) {
            int sum = 0 ;
            for(int idx= 0; idx < basket; idx++) {
                if(usedFirst[idx]) {
                    sum += firstBasket[idx] * firstBasket[idx];
                }
            }
            if(sum > maxFirst) maxFirst = sum;
        }
        else if(num == 2) {
            int sum = 0 ;
            for(int idx= 0; idx < basket; idx++) {
                if(usedSecond[idx]) {
                    sum += secondBasket[idx] * secondBasket[idx];
                }
            }
            if(sum > maxSecond) maxSecond = sum;
            //System.out.println("sum " + sum);
        }
    }
 
    public static void powerSetFirst(int elementIdx, int sum) {
        if(sum > limit) return;
 
        if(elementIdx == basket) {
            calculate(1);
            return;
        }
 
        usedFirst[elementIdx] = true;
        powerSetFirst(elementIdx+1, sum + firstBasket[elementIdx]);
 
        usedFirst[elementIdx] = false;
        powerSetFirst(elementIdx+1, sum);
 
    }
 
    public static void powerSetSecond(int elementIdx, int sum) {
        if(sum > limit) return;
 
        if(elementIdx == basket) {
            calculate(2);
            return;
        }
 
        usedSecond[elementIdx] = true;
        powerSetSecond(elementIdx+1, sum + secondBasket[elementIdx]);
 
        usedSecond[elementIdx] = false;
        powerSetSecond(elementIdx+1, sum);
 
    }
 
    public static void honey() {
        for(int row = 0; row < size; row++) {
            for(int col = 0; col <= size - basket; col++) {
                maxFirst = 0;
                for(int idx = 0; idx < basket; idx++) {
                    firstBasket[idx] = map[row][col + idx];
                }
 
                powerSetFirst(0, 0);
                for(int nextRow = 0; nextRow < size; nextRow++) {
                    for(int nextCol = 0; nextCol <= size - basket; nextCol++) {
                        if(nextRow == row && (nextCol > col-basket && nextCol < col + basket)) continue;
                        //System.out.println("nextCol " + nextCol);
 
                        maxSecond = 0;
                        for(int idx = 0; idx < basket; idx++) {
                            secondBasket[idx] = map[nextRow][nextCol + idx];
                        }
                        powerSetSecond(0 , 0);
                        if(totalProfit < maxFirst + maxSecond) {
                            totalProfit = maxFirst + maxSecond;
                        }
                    }
                }
 
 
            }
        }
    }
 
 
    public static void main(String args[]) throws IOException {
 
        bf = new BufferedReader(new InputStreamReader(System.in));
        int Test = Integer.parseInt(bf.readLine().trim());
 
        for(int tcase = 1; tcase <= Test; tcase++) {
            maxFirst = 0;
            maxSecond = 0;
            totalProfit = 0;
            st = new StringTokenizer(bf.readLine().trim());
            size = Integer.parseInt(st.nextToken());
            basket = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            map = new int[size][size];
 
 
            firstBasket = new int[basket];
            secondBasket = new int[basket];
            usedFirst = new boolean[basket];
            usedSecond = new boolean[basket];
 
 
            for(int row = 0; row < size; row++) {
                st = new StringTokenizer(bf.readLine().trim());
                for(int col = 0; col < size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }
 
            honey();
            System.out.println("#"+tcase + " " +totalProfit);
        }
 
    }
 
}
