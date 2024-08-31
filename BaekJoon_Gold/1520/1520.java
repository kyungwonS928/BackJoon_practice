import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int num;
    static int ROW;
    static int COL;
    static int map[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int slide;
    static int dp[][];

    public static int dfs(int row, int col) {
        if(row == ROW -1 && col == COL -1) {
            return 1;
        }

        if(dp[row][col] != -1) {
            return dp[row][col];
        } else {
            dp[row][col] = 0;

            for(int dir = 0; dir < 4; dir++) {
                int nx = row + dx[dir];
                int ny = col + dy[dir];


                if(nx < 0 || ny < 0 || nx >= ROW || ny >= COL) continue;

                if(map[nx][ny] < map[row][col]) {
                    dp[row][col] += dfs(nx, ny);
                }
            }
        }

        return dp[row][col];

    }



    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //num = Integer.parseInt(br.readLine());  // 테스트케이스 수

        st = new StringTokenizer(br.readLine().trim());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];
        dp = new int[ROW][COL];
        for(int row = 0; row < ROW; row++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int col = 0; col < COL; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                dp[row][col] = -1;
            }
        }


        //dp[0][0] = 1;





        System.out.println(dfs(0, 0));
        
    }
}
