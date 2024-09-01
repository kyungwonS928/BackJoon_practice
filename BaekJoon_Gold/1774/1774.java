import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int star;
    static class Star {
        int x, y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge> {
        int start, end;
        double weight;
        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }
    static Star stars[];
    static int parents[];
    static Edge zodiac[];
    static int already;

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



    public static void main(String args[]) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

//        int Test = Integer.parseInt(bf.readLine().trim());
//
//        for(int tcase = 1; tcase <= Test; tcase++) {
        st = new StringTokenizer(bf.readLine().trim());
        star = Integer.parseInt(st.nextToken());
        already = Integer.parseInt(st.nextToken());

        stars = new Star[star];
        for(int i = 0; i < star; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            stars[i] =new Star(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        zodiac = new Edge[(star *(star-1))/2];
        int idx = 0;
        for(int i = 0; i < star; i++) {
            for(int j = i+1; j < star; j++) {
                zodiac[idx++] = new Edge(i, j, Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2)));
            }
        }

        Arrays.sort(zodiac);

        parents = new int[star+1];
        Arrays.fill(parents, -1);



        int cnt = 0;
        double cost = 0;
        for(int i = 0; i < already; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(union(first-1, second-1)) cnt++;

        }

        for(Edge edge : zodiac) {
            if(union(edge.start, edge.end)) {
                cost += edge.weight;
                if(++cnt == star -1) break;
            }
        }

        System.out.printf("%.2f", cost);
 //       }
    }


}