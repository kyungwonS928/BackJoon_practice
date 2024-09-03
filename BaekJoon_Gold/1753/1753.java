import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 1. 정점의 개수, 간선의 개수를 입력받는다.
// 2. 시작 정점의 번호를 입력받는다.
// 3. 간선을 입력받는다.
// 4. 다익스트라 알고리즘을 적용한다.
// 4-1. 

public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static class Edge {
		int end, weight;
		
		public Edge (int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	static int vertex;
	static int edge;
	static int start;
	static List<Edge> adjList[];
	static int dist[];
	static int INF = Integer.MAX_VALUE;
	static boolean visited[];
	
	public static void dijkstra() {
		dist[start] = 0;
		
		while(true) {
			int idx = -1;
			for(int i = 1; i <= vertex; i++) {
				   if(visited[i]) continue;
				   if(idx == -1) idx = i;
				   else if(dist[i] < dist[idx]) idx = i;
			   }
			   if(idx == -1 || dist[idx] == INF) break;
			   visited[idx] = true;
			   for(Edge nxt : adjList[idx])
				   dist[nxt.end] = Math.min(dist[nxt.end], dist[idx] + nxt.weight);
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 br = new BufferedReader(new InputStreamReader(System.in));
		 sb = new StringBuilder();
		 st = new StringTokenizer(br.readLine().trim());
		 vertex = Integer.parseInt(st.nextToken());
		 edge = Integer.parseInt(st.nextToken());
		 
		 start = Integer.parseInt(br.readLine().trim());
		 
		 adjList = new ArrayList[vertex+1];
		 for(int idx = 1; idx <= vertex; idx++) {
			 adjList[idx] = new ArrayList<>();
		 }
		 
		 
		 for(int idx = 0; idx < edge; idx++) {
			 st = new StringTokenizer(br.readLine().trim());
			 int startV = Integer.parseInt(st.nextToken());
			 
			 adjList[startV].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		 }
		 
		 dist = new int[vertex+1];
		 Arrays.fill(dist, INF);
		 
		 
		 visited = new boolean[vertex+1];
		 dijkstra();
		 
		 for(int idx = 1; idx <= vertex; idx++) {
			 if(dist[idx] == Integer.MAX_VALUE) sb.append("INF" + "\n");
			 else sb.append(dist[idx] + "\n");
		 }
		 
		 System.out.println(sb.toString());
	}

}
