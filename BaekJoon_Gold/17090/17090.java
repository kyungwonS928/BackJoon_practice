import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int ROW, COL;
    static char[][] map; // map을 char 배열로 변경
    static final int U = 3, R = 0, L = 2, D = 1;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dp;

    // 탈출 가능 여부를 체크하는 DFS
    static int dfs(int row, int col) {
        if (row < 0 || row >= ROW || col < 0 || col >= COL) {
            return 1; // 미로를 벗어나면 탈출 가능
        }

        if (dp[row][col] != -1) {
            return dp[row][col]; // 이미 방문한 경우 결과 반환
        }

        dp[row][col] = 0; // 일단 탈출 불가능하다고 가정

        // 각 방향에 따른 DFS 호출
        if (map[row][col] == 'U') {
            dp[row][col] = dfs(row + dx[U], col + dy[U]);
        } else if (map[row][col] == 'R') {
            dp[row][col] = dfs(row + dx[R], col + dy[R]);
        } else if (map[row][col] == 'L') {
            dp[row][col] = dfs(row + dx[L], col + dy[L]);
        } else if (map[row][col] == 'D') {
            dp[row][col] = dfs(row + dx[D], col + dy[D]);
        }

        return dp[row][col];
    }

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new char[ROW][COL]; // map 배열을 char로 선언
        dp = new int[ROW][COL]; // dp 배열 선언

        // 입력 받기
        for (int row = 0; row < ROW; row++) {
            String line = br.readLine().trim();
            for (int col = 0; col < COL; col++) {
                map[row][col] = line.charAt(col); // char로 입력 받기
                dp[row][col] = -1; // dp 배열을 -1로 초기화
            }
        }

        // 각 칸에서 탈출 가능 여부 계산
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                dfs(row, col);
            }
        }

        // 탈출 가능한 칸의 개수 출력
        int escapeCount = 0;
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (dp[row][col] == 1) {
                    escapeCount++; // 탈출 가능한 칸의 개수를 셈
                }
            }
        }

        System.out.println(escapeCount); // 결과 출력
    }
}
