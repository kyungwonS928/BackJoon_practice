import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int vertexCnt;
    static int edgeCnt;
    static class Edge{
        int start, end;
        long weight;
        public Edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

    }
    static List<Edge> edges;
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



    public static void main(String args[]) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

//        int Test = Integer.parseInt(bf.readLine().trim());
//
//        for(int tcase = 1; tcase <= Test; tcase++) {
            st = new StringTokenizer(bf.readLine().trim());
            vertexCnt = Integer.parseInt(st.nextToken());
            edgeCnt = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            for(int i = 0; i < edgeCnt; i++) {
                st = new StringTokenizer(bf.readLine().trim());

                edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
            }

            edges.sort((a, b) -> Long.compare(a.weight, b.weight));

            parents = new int[vertexCnt +1];
            Arrays.fill(parents, -1);

            int cnt = 0;
            long cost = 0;
            for(Edge edge : edges) {
                if(union(edge.start, edge.end)) {
                    cost += edge.weight;
                    if(++cnt == vertexCnt -1) break;
                }
            }

            System.out.println(cost);
 //       }
    }


}