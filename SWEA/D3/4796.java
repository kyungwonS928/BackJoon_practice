import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
 
// 1. 산의 개수를 입력받는다
// 2. 산의 높이를 입력받는다.
// 3. 반복문을 돌면서 산의 증감을 확인한다.
// 3-1. 해당 산이 이전 산보다 높으면 isUp을 true로 세팅한다
// 3-2. 해당 산이 이전 산보다 낮으면 isUp을 false로 세팅한다.
// 4. 이중 반복문을 돌면서 우뚝선산을 확인한다.
// 4-1. 현재 산의 isUp이 true일때, false가 나올때마다 우뚝 선산을 하나씩 더한다.
// 4-2. false 뒤에 true가 나오면 다음 산에서부터 우뚝선산을 찾는다.
// 4-3. 현재 산의 isUp이 false이고 바로 다음 산의 isUp이 true일때 다시 구간을 찾기 시작한다.
// 4. 우뚝선산이 존재하는 구간의 개수를 출력한다.
 
public class Solution {
 
    //static BufferedReader bf;
    //static StringTokenizer st;
    //static StringBuilder sb;
    static Scanner sc;
    static int kg;
    static int bag;
    static boolean isUp[];
    static int mountain[];
    static int cnt;
    static int mountainRange;
     
    public static void range() {
        int up = 0;
        int down = 0;
        for(int first = 0; first < cnt-1; first++) {
            if(isUp[first] == true) {
                up++;
            } else {
                down++;
            }
             
            if(first != cnt-2 && isUp[first] == false && isUp[first+1] == true) {
                mountainRange += up*down;
                up =0;
                down = 0;
            }
        }
         
        mountainRange += up*down;
         
    }
 
 
 
     
    public static void main(String args[]) throws NumberFormatException, IOException {
        sc= new Scanner(System.in);
 
        int Test = sc.nextInt();
 
        for (int tcase = 1; tcase <= Test; tcase++) {
             
            //
            mountainRange = 0;
            // 1. 산의 개수를 입력받는다
            cnt = sc.nextInt();
            // 2. 산의 높이를 입력받는다.
             
            mountain = new int[cnt];
            isUp = new boolean[cnt-1];
            for (int idx = 0; idx < cnt; idx++) {
                mountain[idx] = sc.nextInt();
                if(idx > 0) {
                    if(mountain[idx] > mountain[idx-1]) isUp[idx-1] = true;
                    else isUp[idx-1] = false;
                }
            }
             
            range();
             
            System.out.println("#" + tcase + " " + mountainRange);
             
        }
 
    }
 
}
