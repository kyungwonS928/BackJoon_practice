// 1. 배열의 크기, 회전 횟수를 입력받는다
// 2. 배열 정보를 입력받는다
// 3, 배열을 회전시킨다
// 3-1. 배열 내에 회전시켜야 하는 사각형의 개수는 Math.min(ROW,COL) /2 개이다. (바깥에서 안쪽 사각형으로)
// 3-2. 회전 횟수만큼 회전한다. - 사각형의 둘레보다 큰 값이 들어오면, 입력된 rotateCnt % 둘레 의 값만큼 회전한 것과 같다
// 3-3. 각 사각형들의 시작점은 대각행렬 위에 있다.(마지막 점이 시작점으로 밀리기 때문에 저장시켜놓는다)
// 3-4. 위, 오른쪽, 아래, 왼쪽을 각각 움직인다. (사각형의 크기는 각 변의 크기 -1 - n (n번째 사각형))
// 3-5. 시작점은 다음 행, 같은 열로 옮겨간다.
// 4. 배열을 출력한다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int map[][];
    static int ROW;
    static int COL;
    static int rotateCnt;

    public static void rotate() {
        // 3-1. 배열 내에 회전시켜야 하는 사각형의 개수는 Math.min(ROW,COL) /2 개이다. (바깥에서 안쪽 사각형으로)
        for (int rect = 0; rect < Math.min(ROW, COL) / 2; rect++) {

            // 3-2. 회전 횟수만큼 회전한다. - 사각형의 둘레보다 큰 값이 들어오면, 입력된 rotateCnt % 둘레 의 값만큼 회전한 것과 같다
            // 각 변마다 칸의 개수를 더하고, 겹치는 4개의 꼭짓점을 뺴준다.
            int round = 2*(ROW - 2 * rect) + 2*(COL - 2 * rect) - 4;
            int rotate = rotateCnt % round;

            for(int curRotate = 0; curRotate < rotate; curRotate++) {

                // 3-3. 각 사각형들의 시작점은 대각행렬 위에 있다.(마지막 점이 시작점으로 밀리기 때문에 저장시켜놓는다)
                int first = map[rect][rect];

                // 현재 사각형에서 가장 아래쪽에 있는 행
                int lastRow = ROW-1-rect;
                // 현재 사각형에서 가장 오른쪽에 있는 열
                int lastCol = COL-1-rect;

                // 3-4. 위, 왼쪽, 아래, 오른쪽 변을 각각 움직인다. (사각형의 크기는 각 변의 크기 -1 - n (n번째 사각형))
                //위( 열)
                for (int next = rect; next <lastCol; next++) {
                    //자신보다 오른쪽에 있는 값
                    map[rect][next] = map[rect][next + 1];
                }

                //오른( 행)
                for (int next = rect; next < lastRow; next++) {
                    //자신보다 아래에 있는 값
                    map[next][lastCol] = map[next + 1][lastCol];
                }

                //아래( 열)
                for (int next = lastCol; next > rect; next--) {
                    //자신보다 왼쪽에 있는 값
                    map[lastRow][next] = map[lastRow][next - 1];
                }

                //왼( 행)

                for(int next = lastRow; next > rect; next--) {
                    //자신보다 위쪽에 있는 값
                    map[next][rect] = map[next-1][rect];
                }

                // 3-5. 시작점은 다음 행, 같은 열로 옮겨간다.
                map[rect+1][rect] = first;
            }



        }
    }


    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        // 1. 배열의 크기, 회전 횟수를 입력받는다
        st = new StringTokenizer(bf.readLine().trim());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());
        rotateCnt = Integer.parseInt(st.nextToken());

        // 2. 배열 정보를 입력받는다
        map = new int[ROW][COL];
        for (int row = 0; row < ROW; row++) {
            st = new StringTokenizer(bf.readLine().trim());
            for (int col = 0; col < COL; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // 3, 배열을 회전시킨다

            rotate();


        // 4. 배열을 출력한다
        for(int row = 0; row < ROW; row++) {
            for(int col = 0; col < COL; col++) {
               sb.append(map[row][col] + " ");
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
