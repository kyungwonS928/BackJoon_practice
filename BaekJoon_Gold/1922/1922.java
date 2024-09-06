import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 1. 컴퓨터의 수를 입력받는다.
// 2. 연결할 수 있는 선의 수를 입력받는다.
// 3. 시작 컴퓨터, 끝 컴퓨터, 연결 비용을 입력받는다.
// 4. 컴퓨터를 연결한다.
// 4-1. 컴퓨터를 집합으로 보고 parent 배열을 -1로 초기화한다.
// 4-2. 연결 비용에 대해서 정렬한다.
// 4-3. 연결 비용이 적은 것 부터 컴퓨터를 연결한다.
// 4-4. 이미 연결되어있으면 더이상 연결하지 않는다.
// 5. 최소 연결 비용을 출력한다.



public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int computer;
	static int cable;
	static Edge cables[];
	static int parents[];
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
	
	
	public static int findSet(int me) {
		if(parents[me] == -1) return me;
		return parents[me] = findSet(parents[me]);
	}
	
	public static boolean union(int start, int end) {
		int aRoot = findSet(start);
		int bRoot = findSet(end);
		
		// 4-4. 이미 연결되어있으면 더이상 연결하지 않는다.
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		// 1. 컴퓨터의 수를 입력받는다.
		
		computer = Integer.parseInt(br.readLine().trim());
		
		// 2. 연결할 수 있는 선의 수를 입력받는다.
		cable = Integer.parseInt(br.readLine().trim());
		
		// 3. 시작 컴퓨터, 끝 컴퓨터, 연결 비용을 입력받는다.
		cables = new Edge[cable];
		for(int idx = 0; idx < cable; idx++	 ) {
			st = new StringTokenizer(br.readLine().trim());
			cables[idx] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		// 4. 컴퓨터를 연결한다.
		// 4-1. 컴퓨터를 집합으로 보고 parent 배열을 -1로 초기화한다.
		parents = new int[computer+1];
		Arrays.fill(parents, -1);
		// 4-2. 연결 비용에 대해서 정렬한다.
		Arrays.sort(cables);
		
		// 4-3. 연결 비용이 적은 것 부터 컴퓨터를 연결한다.
		int minCost = 0;
		int connectCnt = 0;
		for(Edge edge:cables) {
			if(union(edge.start, edge.end)) {
				minCost += edge.weight;
				if(++connectCnt == computer-1) break;
			}
		}
		
		// 5. 최소 연결 비용을 출력한다.
		System.out.println(minCost);
		
		
	}

}
