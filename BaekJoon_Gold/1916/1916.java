import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int city;
    static int busCnt;
    static class Route {
        int end;
        int weight;
        public Route(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static List<Route> bus[];
    static int dist[];
    static boolean visited[];
    static int start;
    static int end;

    public static int dijkstra(int startCity, int endCity) {


        for(int idx = 1; idx <= city; idx++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int curIdx = 1; curIdx <= city; curIdx++) {
                if(!visited[curIdx] && min > dist[curIdx]) {
                    min = dist[curIdx];
                    minIdx = curIdx;
                }
            }

            if(minIdx == -1) break;
            visited[minIdx] = true;

            for(Route next : bus[minIdx]) {
                if(dist[next.end] > min + next.weight) {
                    dist[next.end] = min + next.weight;
                }
            }

        }




        return dist[endCity];
    }


    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        city = Integer.parseInt(br.readLine());
        busCnt = Integer.parseInt(br.readLine());

        bus = new ArrayList[city+1];
        for (int i = 1; i <= city; i++) {
            bus[i] = new ArrayList<>();
        }

        for(int cnt = 0; cnt < busCnt; cnt++) {
            st = new StringTokenizer(br.readLine().trim());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            bus[first].add(new Route(second, third));
        }

        st = new StringTokenizer(br.readLine().trim());
        start  = Integer.parseInt(st.nextToken());
        end  = Integer.parseInt(st.nextToken());

        visited=new  boolean[city+1];
        dist = new int[city+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        System.out.println(dijkstra(start, end));
    }
}
