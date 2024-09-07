import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int num;
    static List<Node> adjList[];
    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    };

    static boolean visited[];
    static int max;
    static int maxNode;

    public static void dfs(int cur, int len) {
        if(len > max) {
            max = len;
            maxNode = cur;
        }

        visited[cur] = true;

        for(Node n: adjList[cur]) {
            if(!visited[n.end]) {
                dfs(n.end, n.cost + len);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        adjList = new ArrayList[num+1];
        for(int i = 0; i <= num; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < num-1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[first].add(new Node(second, weight));
            adjList[second].add(new Node(first, weight));


        }

        visited = new boolean[num+1];
        dfs(1, 0);

        visited = new boolean[num+1];
        max=0;
        dfs(maxNode, 0  );

        System.out.println(max);
    }

}
