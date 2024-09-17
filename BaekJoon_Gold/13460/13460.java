import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

// . : 빈칸 , # : 벽, 0 : 구멍

// 1. row, col의 크기를 입력받는다
// 2. 지도 모양을 입력받는다
// 3. 구슬을 이동시킨다
// 3-1. 10회 이상 이동했으면 실패
// 3-2. 파란색이 먼저 구멍에 들어갔다면 실패
// 3-3. 붉은색이 구멍에 들어갔다면, 들어갔을때 이동횟수의 최소값을 구한다.


public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int ROW;
    static int COL;
    static Pair red;
    static Pair blue;
    static Pair hole;

    static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static char map[][];
    //위, 아래, 오, 왼
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int moveCnt;
    static boolean visited[][][][];

    static void move(int redRow, int redCol, int blueRow, int blueCol, int depth) {
        if (depth > 10 || moveCnt <= depth) {
            return;
        }

        if (blueRow == hole.row && blueCol == hole.col) {
            return;
        }

        if (redRow == hole.row && redCol == hole.col) {
            moveCnt = Math.min(depth, moveCnt);
            return;
        }

        // System.out.println(depth + " " + redRow + " " + redCol);
        visited[redRow][redCol][blueRow][blueCol] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = redRow;
            int ny = redCol;

            int bnx = blueRow;
            int bny = blueCol;


            while (map[nx + dx[dir]][ny + dy[dir]] != '#' && map[nx][ny] != 'O') {

                nx += dx[dir];
                ny += dy[dir];
            }

            while (map[bnx + dx[dir]][bny+ dy[dir]] != '#' && map[bnx][bny] != 'O') {
                bnx += dx[dir];
                bny += dy[dir];

            }


            if(nx == bnx && ny == bny && map[nx][ny] != 'O') {
                int redMove = Math.abs(nx - redRow) + Math.abs(ny - redCol);
                int blueMove = Math.abs(bnx - blueRow) + Math.abs(bny - blueCol);

                if(redMove > blueMove) {
                    nx -= dx[dir];
                    ny -= dy[dir];
                } else {
                    bnx -= dx[dir];
                    bny -= dy[dir];
                }
            }

            if(!visited[nx][ny][bnx][bny]) move(nx, ny, bnx, bny, depth+1);
        }
        visited[redRow][redCol][blueRow][blueCol] = false;

    }


    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new char[ROW][COL];
        for (int row = 0; row < ROW; row++) {
            String line = br.readLine();
            for (int col = 0; col < COL; col++) {
                map[row][col] = line.charAt(col);
                if (map[row][col] == 'R') {
                    red = new Pair(row, col);
                    map[row][col] = '.';
                } else if (map[row][col] == 'B') {
                    blue = new Pair(row, col);
                    map[row][col] = '.';
                } else if (map[row][col] == 'O') {
                    hole = new Pair(row, col);
                }
            }
        }

        visited = new boolean[ROW][COL][ROW][COL];
        moveCnt = 987654321;
        move(red.row, red.col, blue.row, blue.col, 0);

        if(moveCnt == 987654321) System.out.println(-1);
        else System.out.println(moveCnt);
    }
}
