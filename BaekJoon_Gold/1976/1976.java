import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int num;
    static int cnt;
    static int parents[];
    static int plan[];

    public static int find(int me) {
        if(parents[me] == -1) return me;
        else return parents[me] = find(parents[me]);
    }

    public static boolean union(int first, int second) {
        int aRoot = find(first);
        int bRoot = find(second);

        if(aRoot == bRoot) return false;

        parents[aRoot] = bRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        num = Integer.parseInt(br.readLine());
        cnt = Integer.parseInt(br.readLine());

        parents = new int[num+1];
        Arrays.fill(parents, -1);

        for(int i = 0; i< num; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< num; j++) {
                int operate = Integer.parseInt(st.nextToken());
                if(operate == 1) {
                    union(i+1, j+1);
                }
            }
        }

        plan = new int[cnt];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<cnt; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        int same = find(plan[0]);
        boolean possible = true;
        for(int i = 1; i<cnt; i++) {
            if(find(plan[i]) != same) {
                possible = false;
                break;
            }
        }

        if(possible) System.out.println("YES");
        else System.out.println("NO");



    }

}
