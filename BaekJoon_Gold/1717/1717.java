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
        st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());

        parents = new int[num+1];
        Arrays.fill(parents, -1);

        for(int i = 0; i< cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int operate = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(operate == 1) {
                if(find(first) == find(second)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if(operate == 0) {
                union(first, second);
            }
        }



    }

}
