// 1. 재료 개수를 입력받는다
// 2. 재료들의 시너지에 대한 배열을 입력받는다.
// 2-1. 같은 재료에 대한 시너지는 0으로 주어진다.
// 3. 각 재료가 어떤 음식이 될지 조합을 구한다.
// 3-1. 재료의 개수/2 개를 선택하면 return;
// 3-2. elementIdx(재료의 인덱스)가 A 음식이 되는 경우(1), B 음식이 되는경우(2)의 조합을 구한다
// 3-3. 조합이 완성되면 음식의 시너지 값을 계산한다
// 4. 음식의 시너지 값을 구한다.
// 4-1. 2중 배열을 돌면서, selectIngredient[row]와 selectIngredient[col] 이 모두 1인 경우 A의 음식으로, 반대의 경우 B로 계산한다.
// 4-2. 반복문이 끝난 후, 두 음식의 시너지 최소값을 업데이트한다
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution {
 
    static BufferedReader bf;
    static StringTokenizer st;
    static int size;
    static int synergy[][];
    static int selectIngredient[];
    static int best;
 
    public static void calculator() {
 
        int foodA = 0;
        int foodB = 0;
 
 
        for(int row = 0; row < size; row++) {
            for(int col = row; col < size; col++) {
                if(row == col) continue;
                if(selectIngredient[row] ==1 && selectIngredient[col]==1) {
                    foodA += synergy[row][col] + synergy[col][row];
                } else if(selectIngredient[row] ==0 && selectIngredient[col]==0) {
                    foodB += synergy[row][col] + synergy[col][row];
                }
            }
        }
        //System.out.println("A " + foodA + " B " + foodB);
        if(best > Math.abs(foodA - foodB)) {
            best = Math.abs(foodA - foodB);
        }
    }
 
    public static void combination(int elementIdx, int selectIdx) {
 
        if(selectIdx == size/2) {
            calculator();
            return;
        }
 
        if(elementIdx == size) {
            return;
        }
 
        selectIngredient[elementIdx] = 1;
        combination(elementIdx+1, selectIdx+1);
 
        selectIngredient[elementIdx] = 0;
        combination(elementIdx+1, selectIdx);
 
    }
 
 
 
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
 
        int Test = Integer.parseInt(bf.readLine().trim());
 
        for(int tcase = 1; tcase <= Test; tcase++) {
            best = 987654321;
            size = Integer.parseInt(bf.readLine().trim());
            synergy = new int[size][size];
            selectIngredient = new int[size];
 
            for(int row = 0; row < size; row++) {
                st = new StringTokenizer(bf.readLine().trim());
                for(int col = 0; col < size; col++) {
                    synergy[row][col] = Integer.parseInt(st.nextToken());
                }
            }
 
            combination(0, 0);
 
            System.out.println("#" + tcase + " " + best);
 
        }
 
 
    }
}
