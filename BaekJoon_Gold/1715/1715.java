import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int num;
    static PriorityQueue<Integer> pq;
    static int sum;
    static int total;


    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        pq = new PriorityQueue<>();
        for(int i = 0; i < num; i++) {

            pq.offer(Integer.parseInt(br.readLine()));

        }

        while(pq.size() > 1) {
            sum = pq.poll() + pq.poll();
            pq.offer(sum);
            total += sum;
        }

        System.out.println(total);

    }
}
