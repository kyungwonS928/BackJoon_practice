import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int board;
    static int cnt;
    static boolean isUsed1[] = new boolean[40];
    static boolean isUsed2[] = new boolean[40];
    static boolean isUsed3[] = new boolean[40];



    public static void chess(int cur) {
        if(cur == board) {
            cnt++;
            return;
        }

        for (int i = 0; i < board; i++) { // (cur, i)에 퀸을 놓을 예정
            if (isUsed1[i] || isUsed2[i+cur] || isUsed3[cur-i+board-1]) // column이나 대각선 중에 문제가 있다면
                continue;
            isUsed1[i] = true;
            isUsed2[i+cur] = true;
            isUsed3[cur-i+board-1] = true;
            chess(cur+1);
            isUsed1[i] = false;
            isUsed2[i+cur] = false;
            isUsed3[cur-i+board-1] = false;
        }
    }


    public static void main(String[] args) throws IOException {


        br = new BufferedReader(new InputStreamReader(System.in));

        board = Integer.parseInt(br.readLine());

        chess(0);
        System.out.println(cnt);
    }

}
