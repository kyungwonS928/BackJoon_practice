import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int house;
    static int edgeCnt;
    static class Edge implements Comparable<Edge> {
        int start, end;
        int weight;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    static int parents[];
    static Edge connect[];

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


        while(true) {

            st = new StringTokenizer(bf.readLine().trim());
            house = Integer.parseInt(st.nextToken());
            edgeCnt = Integer.parseInt(st.nextToken());

            if(house == 0 && edgeCnt == 0) break;

            connect = new Edge[edgeCnt];
            int sum =0;
            for(int i = 0; i < edgeCnt; i++) {
                st = new StringTokenizer(bf.readLine().trim());
                connect[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                sum += connect[i].weight;
            }


            Arrays.sort(connect);

            parents = new int[house+1];
            Arrays.fill(parents, -1);

            int cnt = 0;
            int cost = 0;
            for(Edge edge : connect) {
                if(union(edge.start, edge.end)) {
                    cost += edge.weight;
                    if(++cnt == house-1) break;
                }
            }

            sb.append((sum - cost) + "\n");
        }
        System.out.println(sb.toString());

    }


}