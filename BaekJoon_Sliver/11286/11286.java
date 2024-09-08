import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int cnt;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o1) == Math.abs(o2)) {
                return o1.compareTo(o2);
            }
            return Math.abs(o1) - Math.abs(o2);
        }
    });



    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(cnt-- > 0) {
            int input = Integer.parseInt(br.readLine().trim());
            if(input == 0) {
                if(pq.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(pq.poll() + "\n");
                }
            } else {
                pq.offer(input);
            }
        }

        System.out.println(sb.toString());

    }
}
