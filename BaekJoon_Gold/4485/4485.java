import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1. 지도의 크기를 입력받는다.
// 2. 지도 상에서 도둑루피의 정보를 입력받는다.
// 3. (0, 0)에서 (size-1, size-1) 까지 가는데 도둑루피의 합이 최소가 되는 경로를 구한다.
// 3-1. 방문 배열, 최소 이동 비용에 대한 배열과, 간선에 대한 우선순위가 있는 큐를 만든다.
// 3-2. 큐가 빌때까지
// 3-3. 

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int size;
	static int map[][];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static final int INF = Integer.MAX_VALUE;
	static class Node {
		int row, col;
		int weight;
		public Node(int row, int col, int weight) {
			super();
			this.row = row;
			this.col = col;
			this.weight = weight;
		}
	}
	
	public static int getMinThief() {
		boolean[][] visited = new boolean[size][size];
		int[][] minThief = new int[size][size];
		
		PriorityQueue<Node> pQue = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
		
		for(int row = 0; row < size; row++) {
			Arrays.fill(minThief[row],INF);
		}
		
		minThief[0][0] = map[0][0];
		pQue.offer(new Node(0, 0, minThief[0][0]));
		
		while(!pQue.isEmpty()) {
			Node cur = pQue.poll();
			
			if(visited[cur.row][cur.col]) continue;
			
			visited[cur.row][cur.col]= true;
			if(cur.row == size-1 && cur.col == size-1) return cur.weight;
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur.row + dx[dir];
				int ny = cur.col + dy[dir];
				
				if(nx >= 0 && nx < size && ny >= 0 && ny < size && !visited[nx][ny]) {
					if(minThief[nx][ny] > cur.weight+map[nx][ny]) {
						minThief[nx][ny] = cur.weight+map[nx][ny];
						pQue.offer(new Node(nx, ny, minThief[nx][ny]));
					}
				}
				
			}
			
		}
		
		return -1;
	}
	
	public static void main(String args[]) throws IOException {
		br= new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int tcase = 1;
		while(true) {
			size = Integer.parseInt(br.readLine().trim());
			if(size == 0) break;
			
			map = new int[size][size];
			for(int row = 0; row < size; row++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int col = 0; col < size; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("Problem " + tcase + ": " + getMinThief() + "\n");
			
			tcase++;
		}
		
		System.out.println(sb.toString());
	}

	
}
