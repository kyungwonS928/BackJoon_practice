import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int num;
    static  class Team implements Comparable<Team> {
        int start, end;

        public Team(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Team o) {
            if(this.end == o.end) return this.start - o.start;

            return this.end - o.end;

        }
    }

    static Team reservation[];

    public static void main(String args[]) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(bf.readLine());

        reservation = new Team[num];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(bf.readLine());
            reservation[i] = new Team(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        }


        Arrays.sort(reservation);

        int count = 0;
        int prev_end = 0;
        for(int i = 0; i < num; i++) {
            if(prev_end <= reservation[i].start) {
               count++;
               prev_end = reservation[i].end;
            }

        }


        System.out.println(count);

    }


}