import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int vertex;
    static int edge;
    static List<Node> adjList[];
    static final int INF = 200000000;
    
    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int dist[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        adjList = new ArrayList[vertex + 1];
        for (int idx = 1; idx <= vertex; idx++) {
            adjList[idx] = new ArrayList<>();
        }
        
        dist = new int[vertex + 1];
        visited = new boolean[vertex + 1];

        // 간선 정보 입력
        for (int idx = 0; idx < edge; idx++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[start].add(new Node(end, cost));
            adjList[end].add(new Node(start, cost)); // 양방향 그래프
        }

        st = new StringTokenizer(br.readLine().trim());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 간선이 없으면 경로가 존재할 수 없으므로 -1을 출력
        if (edge == 0) {
            System.out.println(-1);
            return;
        }
        
        // 경로 1: 1 → v1 → v2 → N 경로의 최단 거리
        int route1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, vertex);
        int route2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, vertex);

        int result = Math.min(route1, route2);
        
        // Handle unreachable cases
        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int dijkstra(int start, int end) {
    	Arrays.fill(visited, false);
        Arrays.fill(dist,  INF);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (visited[cur.end]) continue;
            visited[cur.end] = true;

            for (Node next : adjList[cur.end]) {
                if (!visited[next.end] &&dist[next.end] > dist[cur.end] + next.cost) {
                    dist[next.end] = dist[cur.end] + next.cost;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }

        // end까지 도달할 수 없을 경우
        return dist[end];
    }
}
