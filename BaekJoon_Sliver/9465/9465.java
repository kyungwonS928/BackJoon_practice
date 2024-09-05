import java.util.*;
import java.io.*;

// 1. 시작점의 개수, 끝점의 개수를 입력받는다.
// 2. 다리를 잇는다
// 2-1. 다리를 잇는 경우의 수는 mCn과 같다 -> 이항계수 (m = end, n = start)
//      이항계수 그래프를 만든다.
// 3. dp[m][n] 값을 출력한다.

public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int startBridge;
    static int endBridge;
    static int size;
    static int sticker[][];
    static int dp[][];



    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        int Test = Integer.parseInt(bf.readLine());
        sb = new StringBuilder();

        for(int tcase = 0; tcase < Test; tcase++) {
            size = Integer.parseInt(bf.readLine());

            dp = new int[2][size+1];
            sticker = new int[2][size+1];

            for(int row = 0; row < 2; row++) {
                st = new StringTokenizer(bf.readLine());
                for(int col = 1; col < size+1; col++) {
                    sticker[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            //시작점
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for(int idx = 2; idx < size+1; idx++) {
                dp[0][idx] = Math.max(dp[1][idx-2], dp[1][idx-1]) + sticker[0][idx];
                dp[1][idx] = Math.max(dp[0][idx-2], dp[0][idx-1]) + sticker[1][idx];
            }

            sb.append(Math.max(dp[0][size], dp[1][size]) + "\n");
        }

        System.out.println(sb.toString());
    }
}

