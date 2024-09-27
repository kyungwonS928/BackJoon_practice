import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int ROW;
    static int COL;
    static char map[][];
    static boolean key[];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static class Pair{
        int row, col;
        char door;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Pair(char door, int row, int col) {
            this.row = row;
            this.door = door;
            this.col = col;
        }
    }
    static List<Pair> lock;
    static int stolen;
    static boolean visited[][];
    static Queue<Pair> q;


    public static void bfs() {
        visited = new boolean[ROW][COL];
        q = new ArrayDeque<>();

        for(int row = 0; row < ROW; row++) {
            for(int col = 0; col < COL; col++) {
                if(row == 0 || col == 0 || row == ROW-1 || col == COL-1) {

                    if(map[row][col] == '.') {
                        visited[row][col] = true;
                        q.offer(new Pair(row, col));
                    }
                    else if(map[row][col] >= 'a' && map[row][col] <= 'z') {
                        if(!key[map[row][col]-'a']){
                            key[map[row][col]-'a'] = true;
                            openDoor(map[row][col]-'a');
                        }

                        q.offer(new Pair(row, col));
                    } else if(map[row][col] == '$') {
                        stolen++;
                        visited[row][col] = true;
                        q.offer(new Pair(row, col));
                    } else if(map[row][col] >= 'A' && map[row][col] <= 'Z') {
                        if(key[map[row][col]-'A']) {
                            visited[row][col] = true;
                            q.offer(new Pair(row, col));
                        } else {
                            lock.add(new Pair(map[row][col], row, col));
                        }
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            //System.out.println("cur "+ cur.row + " " + cur.col);

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.row + dx[dir];
                int ny = cur.col + dy[dir];

                if (nx < 0 || ny < 0 || nx >= ROW || ny >= COL || visited[nx][ny]) continue;
                if (map[nx][ny] == '*') continue;

                if (map[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                    continue;
                } else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                    //System.out.println("key "+ map[nx][ny] + " is locked " + key[map[nx][ny] - 'A']);
                    if (key[map[nx][ny] - 'A']) {
                        visited[nx][ny] = true;
                        q.offer(new Pair(nx, ny));
                    } else {
                        lock.add(new Pair(map[nx][ny], nx, ny));
                    }
                } else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {

                    if (!key[map[nx][ny] - 'a']) {
                        key[map[nx][ny] - 'a'] = true;
                        openDoor(map[nx][ny]-'a');
                    }
                    // System.out.print(map[nx][ny] + " ");
                    visited[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                } else if (map[nx][ny] == '$') {
                    stolen++;
                    //System.out.println("stolen "+ nx + " " + ny);
                    visited[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                }


            }

        }
    }

    public static void openDoor(int keyIdx) {
        for (int idx = 0; idx < lock.size(); idx++) {
            if (key[keyIdx] && lock.get(idx).door - 'A' == keyIdx) {
                //System.out.println("keyIdx " +keyIdx);
                q.offer(lock.get(idx));
                lock.remove(idx);
                idx--;
            }
        }
    }


    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int Test = Integer.parseInt(br.readLine());


        for(int tcase = 1; tcase <= Test; tcase++) {
            stolen = 0;
            st = new StringTokenizer(br.readLine());
            ROW = Integer.parseInt(st.nextToken());
            COL = Integer.parseInt(st.nextToken());


            map = new char[ROW][COL];
            lock = new LinkedList<>();
            for(int row = 0; row < ROW; row++) {
                String line = br.readLine();
                for(int col = 0; col < COL; col++) {
                    map[row][col] = line.charAt(col);
                }
            }

            key = new boolean[26];
            String line = br.readLine();
            if(!line.equals("0")) {
                for(int idx = 0; idx < line.length(); idx++) {
                    key[line.charAt(idx) - 'a'] = true;
                }
            }
            bfs();

//            for(int row = 0; row < ROW; row++) {
//                for(int col = 0; col < COL; col++) {
//                    System.out.print(map[row][col] + " ");
//                }
//                System.out.println();
//            }

            sb.append(stolen + "\n");

        }

        System.out.println(sb.toString());

    }
}
