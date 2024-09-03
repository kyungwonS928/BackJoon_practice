import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int ROW;
    static int COL;
    static int map[][];
    static class Pair {
        int x, y;
        int isBreak;

        public Pair(int x, int y, int isBreak) {
            super();
            this.x = x;
            this.y = y;
            this.isBreak = isBreak;
        }

    }
    static int dist[][];

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static boolean bfs() {
        //부순적이 없으면 0 부순적이 있으면 1
        boolean visited[][][] = new boolean[2][ROW][COL];
        dist  = new int[ROW][COL];
        Queue<Pair> que = new ArrayDeque<>();

        que.offer(new Pair(0, 0, 0));
        visited[0][0][0] = true;


        dist[0][0] = 1;

        while(!que.isEmpty()) {
            Pair cur = que.poll();

            for(int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || nx >= ROW || ny < 0 || ny >= COL) continue;

                //다음칸이 벽일때, 부순 벽이 없고, 해당 벽을 방문한적이 없으면
                if (map[nx][ny] == 1 && cur.isBreak == 0 && !visited[1][nx][ny]) {
                    visited[1][nx][ny] = true;
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    que.offer(new Pair(nx, ny, 1));
                }
                // 벽이 아닐 때, 벽을 부순 여부와 상관없이 방문하지 않았다면
                else if (map[nx][ny] == 0 && !visited[cur.isBreak][nx][ny]) {
                    visited[cur.isBreak][nx][ny] = true;
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    que.offer(new Pair(nx, ny, cur.isBreak));
                }

                if(nx == ROW -1 && ny == COL-1) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    return true;
                }
            }


        }
        return false;

    }

    public static void main(String[] args) throws IOException {


        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];
        for(int row = 0; row < ROW; row++) {
            String line = br.readLine().trim();
            for(int col = 0; col < COL; col++) {
                map[row][col] = line.charAt(col) - '0';
            }
        }

        if(ROW-1 == 0 && COL-1 == 0){
            System.out.print(1);
            System.exit(0);
        }

//        for(int i = 0; i < ROW; i++) {
//            for(int j = 0; j < COL; j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }

        if(bfs()) {
            System.out.println(dist[ROW-1][COL-1]);
        } else System.out.println(-1);
    }

}
