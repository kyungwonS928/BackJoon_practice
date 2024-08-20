import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
 
// 1. 재료의 수, 제한 칼로리를 입력받는다
// 2. 재료의 수만큼 점수와 칼로리를 입력받아 배열에 저장한다
// 3. 재료의 대한 부분집합을 구한다.
// 3-1. 칼로리의 총합이 넘어가면 return 한다
// 3-2. 모든 요소를 확인하면 max_score을 업데이트한다
 
 
public class Solution {
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int cnt;
    static int sum_kcal;
    static int elementHam[][];
    static boolean usedElement[];
    static int max_score;
 
    public static void powerSet(int elementIdx,int score,int kcal) {
 
 
        // 3-1. 칼로리의 총합이 넘어가면 return 한다
        if(kcal > sum_kcal) return;
 
        // 3-2. 모든 요소를 확인하면 max_score을 업데이트한다
        if(elementIdx == cnt) {
            max_score = Math.max(max_score, score);
            return;
        }
 
        //선택하는 경우
        usedElement[elementIdx] = true;
        powerSet(elementIdx+1,score + elementHam[elementIdx][0],kcal + elementHam[elementIdx][1]);
 
        usedElement[elementIdx] = false;
        powerSet(elementIdx+1, score, kcal);
    }
 
    public static void main(String[] args) throws NoSuchElementException, IOException {
        // TODO Auto-generated method stub
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        int Test = Integer.parseInt(bf.readLine().trim());
        for(int tcase = 1; tcase <= Test; tcase++) {
            max_score=0;
            // 1. 재료의 수, 제한 칼로리를 입력받는다
            st = new StringTokenizer(bf.readLine().trim());
            cnt = Integer.parseInt(st.nextToken());
            sum_kcal = Integer.parseInt(st.nextToken());
 
 
            elementHam = new int[cnt][2];
            usedElement = new boolean[cnt];
            // 2. 재료의 수만큼 점수와 칼로리를 입력받아 배열에 저장한다
            for(int idx = 0; idx<cnt; idx++) {
                st = new StringTokenizer(bf.readLine().trim());
                for(int input = 0; input<2; input++) {
                    elementHam[idx][input] = Integer.parseInt(st.nextToken());
                }
            }
 
            // 3. 재료에 대한 부분집합을 구한다
            powerSet(0, 0, 0);
 
            System.out.println("#" + tcase + " " + max_score);
 
        }
    }
}
