import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int friend;
    static int cnt;
    static int[][] relation;
    static int[][] dist;

    public static void bacon() {
        for (int k = 1; k <= friend ;k++) {
            for (int i = 1; i <= friend; i++) {
                for (int j = 1; j <= friend; j++) {
                    // 최단경로 초기화
                    if (relation[i][j] > relation[i][k] + relation[k][j]) {
                        relation[i][j] = relation[i][k] + relation[k][j];
                    }
                }
            }
        }
    }



    public static void main(String args[]) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(bf.readLine());
        friend = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());

        relation = new int[friend+1][friend+1];
        dist = new int[friend+1][friend+1];

        for (int i = 1; i <= friend; i++) {
            for (int j = 1; j <= friend; j++) {
                relation[i][j] = 9999;

                if (i == j) {
                    relation[i][j] = 0;
                }
            }
        }


        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            relation[first][second] = 1;
            relation[second][first] = 1;
        }

        bacon();

        int min_val = 9999;
        int min_idx = 0;
        for (int i = 1; i <= friend; i++) {
            int total = 0;
            for (int j = 1; j <= friend; j++) {
                total += relation[i][j];
            }

            if (min_val > total) {
                min_val = total;
                min_idx = i;
            }
        }

        System.out.println(min_idx);

    }
}