import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
 
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int size;
    static int cost;
    static int map[][];
    static class Pair {
        int x;
        int y;
 
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int maxHouse;
 
    public static void calculator() {
 
        for(int curRow = 0; curRow < size; curRow++) {
            for(int curCol = 0; curCol < size; curCol++) {
                for(int manage = 1; manage<=size +5; manage++) {
                    int manageCost = manage*manage + (manage-1)*(manage-1);
                    int houseNum = 0;
                    for(int row = curRow- manage; row < size; row++) {
                        for(int col = curCol - manage; col < size; col++) {
                            if(row < 0 || col < 0 ) continue;
                            if(Math.abs(row - curRow) + Math.abs(col - curCol) >= manage) continue;
                            if(map[row][col] == 1) houseNum++;
                        }
                    }
                    if(manageCost <= houseNum * cost) {
                        if(maxHouse < houseNum)  {
                                maxHouse = houseNum;
 
                        }
                    }
                }
            }
        }
    }
 
 
 
    public static void init() throws IOException {
        st = new StringTokenizer(bf.readLine().trim());
        maxHouse = 0;
        size = Integer.parseInt(st.nextToken());
        map = new int[size][size];
        cost = Integer.parseInt(st.nextToken());
 
        for(int row = 0; row < size; row++) {
            st = new StringTokenizer(bf.readLine().trim());
            for(int col = 0; col < size; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
 
            }
        }
 
    }
 
    public static void main(String[] args) throws IOException {
 
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int Test = Integer.parseInt(bf.readLine());
        for(int tcase = 1; tcase <= Test; tcase++) {
            init();
            calculator();
            sb.append("#" + tcase + " " + maxHouse + "\n");
        }
        System.out.println(sb.toString());
    }
}
