import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int num;
    static PriorityQueue<Integer> min;
    static PriorityQueue<Integer> max;
    static int mid;


    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < num; i++) {

            int input = Integer.parseInt(br.readLine());

            
                if(input < mid) {
                    max.offer(input);
                    if(max.size() -1 > min.size()) {
                        min.offer(max.poll());
                    }

                } else {
                    min.offer(input);
                    if(min.size() - 1 > max.size()) {
                        max.offer(min.poll());
                    }

                }


                if(min.size() > max.size()) {
                    sb.append(min.peek() + "\n");
                    mid = min.peek();
                } else if(min.size() < max.size()) {
                    sb.append(max.peek() + "\n");
                    mid = max.peek();
                } else {
                    sb.append(Math.min(min.peek(), max.peek()) + "\n");
                    mid = Math.min(min.peek(), max.peek());
                }
            




        }

        System.out.println(sb.toString());


    }
}
