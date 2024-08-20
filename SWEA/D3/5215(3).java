import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Solution {
 
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int cnt;
    static int limit;
 
    static int score[];
    static int kcal[];
    static int select[];
 
    static int maxTaste;
 
    // next permutation 알고리즘 구현
    public static boolean nextPermutation(int[] array) {
        int idx = array.length - 1;
 
        // 가장 큰 'i'를 찾음 (앞의 원소가 뒤의 원소보다 작은 최초의 위치)
        while (idx > 0 && array[idx - 1] >= array[idx]) idx--;
 
        if (idx <= 0) return false;  // 더 이상 다음 순열이 없음
 
        int next = array.length - 1;
 
        // 가장 큰 'j'를 찾음 (array[i-1]보다 큰 마지막 위치)
        while (array[next] <= array[idx - 1]) next--;
 
        // 'i-1'과 'j' 위치의 값을 스왑
        swap(array, idx - 1, next);
 
        // 'i' 이후의 값을 뒤집음
        next = array.length - 1;
        while (idx < next) {
            swap(array, idx, next);
            idx++;
            next--;
        }
 
        return true;  // 다음 순열이 생성되었음을 의미
    }
 
    // 배열의 두 원소를 스왑하는 함수
    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
 
 
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int Test = Integer.parseInt(bf.readLine().trim());  // 테스트 케이스 수 입력 받음
 
 
        for (int tcase = 1; tcase <= Test; tcase++) {
            st = new StringTokenizer(bf.readLine().trim());
            cnt = Integer.parseInt(st.nextToken());  // 재료의 수
            limit = Integer.parseInt(st.nextToken());  // 제한 칼로리
 
            score = new int[cnt];
            kcal = new int[cnt];
 
            // 재료에 대한 맛 점수와 칼로리 정보를 입력받음
            for (int idx = 0; idx < cnt; idx++) {
                st = new StringTokenizer(bf.readLine().trim());
                score[idx] = Integer.parseInt(st.nextToken());
                kcal[idx] = Integer.parseInt(st.nextToken());
            }
 
            maxTaste = 0;
 
            // 각 재료를 포함할지 말지에 대한 순열을 생성하고 처리
            for (int idx = 0; idx <= cnt; idx++) {
                //2-1. elementUsed List 세팅
                select = new int[cnt];
 
                for (int element = cnt - idx; element < cnt; element++) {
                    select[element] = 1;
                }
 
                //2-2. nextPermutation으로 가능한 조합들 구하기
                do {
                    //3. 만들어진 조합의 칼로리, 점수 계산해서 최대 점수 갱신해주기
                    int currentCal = 0;
                    int currentScore = 0;
                    for (int elementIdx = 0; elementIdx < cnt; elementIdx++) {
                        if (select[elementIdx] == 1) {
                            currentScore += score[elementIdx];
                            currentCal += kcal[elementIdx];
                        }
                    }
                    if (currentCal <= limit && maxTaste < currentScore) {
                        maxTaste = currentScore;
                    }
                } while (nextPermutation(select));
            }
            System.out.println("#" + tcase + " " + maxTaste);
        }
 
    }
}
