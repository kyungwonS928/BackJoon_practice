import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
// 1. 지뢰밭의 크기를 입력받는다.
// 2. 지뢰밭의 정보를 입력받는다.
// 3. 반복문을 돌며, 빈칸을 시작으로 8방을 확인한다
// 3-1. 주변 8칸 중 지뢰의 개수를 확인한다
// 3-2. 자신의 위치에 지뢰의 개수를 입력한다.
// 3-3. 주변 8칸의 주변 지뢰 개수를 구한다.
// 3-4. 주변 8칸 중, 주변 지뢰 개수가 0인 칸으로 이동한다.
 
public class Solution {
 
    static BufferedReader bf;
    static StringTokenizer st;
    static int map[][];
    static int size;
    static int dx[] = {0, -1, 0, 1, 1, -1, 1, -1};
    static int dy[] = {1, 0, -1, 0, 1, -1, -1, 1};
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int cnt;
 
    public static void checkMine(int row, int col) {
        int sum = 0;
        for(int dir = 0; dir < 8; dir++ ) {
            int nx = row + dx[dir];
            int ny = col + dy[dir];
 
            if(nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
            if(map[nx][ny] == '*') sum++;
        }
        if(sum ==0 ) map[row][col] = sum;
    }
 
 
    public static void bfs() {
        ArrayDeque<Pair> que = new ArrayDeque<>();
        boolean visited[][] = new boolean[size][size];
 
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if(map[row][col] == '.' && !visited[row][col]) {
                    checkMine(row, col);
 
                    if(map[row][col] == 0) {
                        cnt++;
 
                        que.add(new Pair(row, col));
                        visited[row][col] = true;
 
                        while(!que.isEmpty()) {
                            Pair cur = que.removeFirst();
 
                            for(int dir = 0; dir < 8; dir++ ){
                                int nx = cur.x + dx[dir];
                                int ny = cur.y + dy[dir];
 
                                if(nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
                                if(map[nx][ny] != '.') continue;
 
                                checkMine(nx, ny);
 
                                if(map[nx][ny] == 0) {
                                    que.offer(new Pair(nx, ny));
                                }
                                visited[nx][ny] = true;
                            }
                        }
                    }
 
 
 
                }
            }
        }
 
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if(map[row][col] == '.' && !visited[row][col]) {
                    cnt++;
                }
            }
        }
 
    }
 
 
 
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
 
        int Test = Integer.parseInt(bf.readLine().trim());
 
        for(int tcase = 1; tcase <= Test; tcase++) {
            cnt = 0;
            size = Integer.parseInt(bf.readLine().trim());
 
            map = new int[size][size];
            for(int row = 0; row < size; row++) {
                String line = bf.readLine().trim();
                for(int col = 0; col < size; col++) {
                    map[row][col] = line.charAt(col);
                }
            }
 
            bfs();
 
//            for(int row = 0; row < size; row++) {
//                for(int col = 0; col < size; col++) {
//                    System.out.print(map[row][col] +" ");
//                }
//                System.out.println();
//            }
 
            System.out.println("#" + tcase + " " +cnt);
        }
 
 
    }
}