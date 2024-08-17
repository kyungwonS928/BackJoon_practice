
//1. 연구소의 크기를 입력받는다
//2. 지도 모양이 주어진다
//3. 빈 칸을 저장하는 배열을 만든다
//4. 이 배열을 활용하여 3개의 원소로 이루어진 조합을 만든다
//5. 조합을 만들면 bfs로 바이러스가 퍼져나가는 경로를 확인한다
//6. 남은 빈칸의 개수를 세어 최대로 빈칸이 남는 경우를 확인한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static int row_size;
    static int col_size;
    static int map[][];
    static List<Pair> wall;
    static Pair selectElement[];
    static class Pair {
        int x;
        int y;

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int maxSafe;
    static int virusCnt;

    public static void virus() {
        int[][] visited = new int[row_size][col_size];
        int[][] tempMap = new int[row_size][col_size];

        // 지도 복사 및 벽 설치
        for (int i = 0; i < row_size; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, col_size);
        }

        for (int idx = 0; idx < 3; idx++) {
            Pair cur = selectElement[idx];
            tempMap[cur.x][cur.y] = 1;
        }

        ArrayDeque<Pair> que = new ArrayDeque<>();
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                if (tempMap[i][j] == 2) {
                    que.addLast(new Pair(i, j));
                }
            }
        }

        while (!que.isEmpty()) {
            Pair cur = que.removeFirst();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= row_size || ny >= col_size) continue;
                if (visited[nx][ny] == 1 || tempMap[nx][ny] != 0) continue;

                visited[nx][ny] = 1;
                tempMap[nx][ny] = 2;  // 바이러스 퍼뜨리기
                que.addLast(new Pair(nx, ny));
            }
        }

        // 안전 영역 계산
        int safeArea = 0;
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                if (tempMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        maxSafe = Math.max(maxSafe, safeArea);
    }

    public static void combination(int elementIdx, int selectIdx) {
        if(selectIdx == 3) {
            virus();

            return;
        }
        if(elementIdx == wall.size()) return;


        selectElement[selectIdx] = wall.get(elementIdx);
        combination(elementIdx+1, selectIdx + 1);

        combination(elementIdx+1, selectIdx);

    }

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(bf.readLine().trim());
        row_size = Integer.parseInt(st.nextToken());
        col_size = Integer.parseInt(st.nextToken());

        map = new int[row_size][col_size];
        wall = new ArrayList<>();
        maxSafe = 0;
        for(int row = 0; row < row_size; row++) {
            st = new StringTokenizer(bf.readLine().trim());
            for(int col = 0; col < col_size; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                if (map[row][col] == 0) {
                    wall.add(new Pair(row, col));
                } else if(map[row][col] == 2) virusCnt++;

            }
        }

        selectElement = new Pair[3];

        combination(0,0);

        System.out.println(maxSafe);
    }
}
