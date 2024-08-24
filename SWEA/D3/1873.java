import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
// 맵의 구성 요소
// 물: 전차가 이동할 수 없다
// 게임 규칙
// 전차는 맵 안에서만 이동한다
// 포탄은 맵 밖/벽돌/강철
// 맵 밖으로 나가는 경우 아무일도 일어나지 않는다
// * 벽돌: 부서지면 평지가 됨
// # 강철: 아무일도 일어나지 않음
 
 
// 동작
// Up, Down, Left, Right : 방향을 바꾸고 빈칸이면 한칸 이동
// Shoot: 전차가 바라보는 방향으로 포탄을 쏜다
 
// 1. 높이와 너비를 입력받는다
// 2. 맵의 정보를 입력받는다
// 2-1. 전차의 초기 위치와 방향을 확인한다.
// 3. 명령어 개수를 입력받는다
// 4. 명령어를 입력받는다
// 5. 명령어 개수 만큼 게임을 진행한다.
 
 
 
 
public class Solution {
 
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int Height;
    static int Width;
    static char map[][];
    static int dir;         //현재 바라보는 방향
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int Up = 0;
    static int Right = 1;
    static int Down = 2;
    static int Left = 3;
    static int orderLength;
    static char order[];
    static int row;     //현재 위치
    static int col;     //현재 위치
    static char mark;
 
    public static void move() {
        int nx = row + dx[dir];
        int ny = col + dy[dir];
 
        if(nx < 0 || nx >= Height || ny < 0 || ny >= Width) {
            return;
        }
 
        if(map[nx][ny] == '.') {
            row = nx;
            col = ny;
        }
    }
 
    public static void shoot() {
        for(int dis = 0; dis < Math.max(Height, Width); dis++) {
            int nx = row + dx[dir] * dis;
            int ny = col + dy[dir] * dis;
 
            if(nx < 0 || nx >= Height || ny < 0 || ny >= Width) {
                break;
            }
 
            if(map[nx][ny] == '#') {
                break;
            }
 
            if(map[nx][ny] == '-') {
                continue;
            }
 
            if(map[nx][ny] == '*') {
                map[nx][ny] = '.';
                break;
            }
 
        }
    }
 
 
    public static void game() {
        for(int round = 0; round < orderLength; round++) {
            char cur = order[round];
 
            if(cur == 'S' ) {
                shoot();
            } else if( cur == 'U') {
                dir = Up;
                mark = '^';
                move();
            } else if( cur == 'D') {
                dir = Down;
                mark = 'v';
                move();
            } else if( cur == 'L') {
                dir = Left;
                mark = '<';
                move();
            } else if( cur == 'R') {
                dir = Right;
                mark = '>';
                move();
            }
        }
    }
 
 
 
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        int Test = Integer.parseInt(bf.readLine().trim());
 
        for(int tcase = 1; tcase <= Test; tcase++) {
            st = new StringTokenizer(bf.readLine().trim());
            Height = Integer.parseInt(st.nextToken());
            Width = Integer.parseInt(st.nextToken());
 
            map = new char[Height][Width];
            for(int height = 0; height < Height; height++) {
                String line = bf.readLine().trim();
                for(int width = 0; width < Width; width++) {
                    map[height][width] = line.charAt(width);
                    if(map[height][width] == '<') {
                        row = height;
                        col = width;
                        dir = Left;
                        mark = '<';
                        map[height][width] = '.';
                    } else if(map[height][width] == '>') {
                        row = height;
                        col = width;
                        dir = Right;
                        mark = '>';
                        map[height][width] = '.';
                    } else if(map[height][width] == '^') {
                        row = height;
                        col = width;
                        dir = Up;
                        mark = '^';
                        map[height][width] = '.';
                    } else if(map[height][width] == 'v') {
                        row = height;
                        col = width;
                        dir = Down;
                        mark = 'v';
                        map[height][width] = '.';
 
                    }
                }
            }
            orderLength = Integer.parseInt(bf.readLine().trim());
            order = new char[orderLength];
            order = bf.readLine().trim().toCharArray();
 
            game();
 
            sb.append("#" + tcase + " ");
            for(int height = 0; height < Height; height++) {
                for(int width = 0; width < Width; width++) {
                    if(height == row && width == col) {
                        map[height][width] = mark;
                    }
                    sb.append(map[height][width]);
                }
                sb.append('\n');
            }
 
             
        }
        System.out.println(sb.toString());
 
    }
}