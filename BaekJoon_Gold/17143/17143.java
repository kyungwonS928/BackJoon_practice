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
    static int CNT;
    static class Shark {
        int row, col, speed, dir, size;
        boolean isAlive;

        public Shark(int row,  int col, int speed, int dir , int size) {
            this.row = row;
            this.size = size;
            this.dir = dir-1;
            this.col = col;
            this.speed = speed;
            this.isAlive = true;
        }
    }
    static Shark sharks[];
    static int map[][];
    static int newMap[][];
    static int catchShark;
    //위, 아래, 오, 왼
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void move() {
        newMap = new int[ROW+1][COL+1];
        for(int idx = 1; idx <= CNT; idx++) {

            if(!sharks[idx].isAlive) continue;
            Shark cur = sharks[idx];

            int moveCnt = 0;
            int rotateCnt = 0;
            if(cur.dir < 2) {
                moveCnt = cur.speed % (ROW * 2 - 2);

                for (int cnt = 0;cnt < moveCnt; ++cnt) {
                    if (cur.row == 1 && cur.dir == 0) {
                        cur.dir = 1;
                    } else if(cur.row == ROW && cur.dir == 1) {
                        cur.dir = 0;
                    }
                    cur.row += dx[cur.dir];
                    cur.col += dy[cur.dir];
                }


            } else {
                moveCnt = cur.speed % (COL * 2 - 2);

                for (int cnt = 0;cnt < moveCnt; ++cnt) {
                    if (cur.col == 1 && cur.dir == 3) {
                        cur.dir = 2;
                    } else if(cur.col == COL && cur.dir == 2) {
                        cur.dir = 3;
                    }
                    cur.row += dx[cur.dir];
                    cur.col += dy[cur.dir];
                }

            }

            if(newMap[cur.row][cur.col] == 0) {
                newMap[cur.row][cur.col] = idx;
            } else {
                if(sharks[newMap[cur.row][cur.col]].size < cur.size) {
                    sharks[newMap[cur.row][cur.col]].isAlive = false;
                    newMap[cur.row][cur.col] = idx;
                } else{
                    cur.isAlive = false;
                }
            }

            map = newMap;
        }


    }


    public static void fishing(int col) {

        for(int row = 1; row <= ROW; row++) {
            if(map[row][col] > 0) {
                catchShark+= sharks[map[row][col]].size;
                sharks[map[row][col]].isAlive = false;
                map[row][col] = 0;
                break;
            }
        }

    }


    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();


            st = new StringTokenizer(br.readLine());
            ROW = Integer.parseInt(st.nextToken());
            COL = Integer.parseInt(st.nextToken());
            CNT = Integer.parseInt(st.nextToken());

            map = new int[ROW+1][COL+1];
            sharks = new Shark[CNT+1];
            for(int idx = 1; idx <= CNT; idx++) {
                st = new StringTokenizer(br.readLine());
                sharks[idx] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                map[sharks[idx].row][sharks[idx].col] = idx;
            }



            for(int col = 1; col <= COL; col++) {
                fishing(col);
                move();
                //System.out.println();

            }


        System.out.println(catchShark);

    }
}
