import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 1. ROW, COL을 입력받는다.
// 2. cheese를 입력받는다.
// 3. 0을 기준으로 bfs를 돈다.
// 3-1. 가장 바깥쪽 모서리는 치즈가 무조건 없기 때문에, 하나의 빈 공간 덩어리가 된다.



public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int cheese[][];
	static int nextCheese[][];
	static int ROW;
	static int COL;
	static int maxCnt;
	static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	static int preCheese;
	static int lastCheese;
	
	public static void count() {
		for(int row = 0; row < ROW; row++) {
			for(int col = 0; col < COL; col++) {
				if(cheese[row][col] == -1) lastCheese++;
			}
		}
	}
	
	public static void reset() {
		for(int row = 0; row < ROW; row++) {
			for(int col = 0; col < COL; col++) {
				if(cheese[row][col] == -1) cheese[row][col] = 0;
			}
		}
	}
	
	
	public static int boundary() {
		boolean visited[][] = new boolean[ROW][COL];
		Queue<Pair> que = new ArrayDeque<>();
		int boundary = 0;
		visited[0][0] = true;
		que.offer(new Pair(0,0));
		
		while(!que.isEmpty()) {
			
			Pair cur = que.poll();
			//System.out.println("x "+ cur.x + " y " + cur.y);
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx < 0 || nx >= ROW || ny < 0 || ny>=COL) continue;
				
				if(cheese[cur.x][cur.y] == 0 && cheese[nx][ny] == 1) {
					boundary++;
					cheese[nx][ny] = -1;
					nextCheese[nx][ny] = 1;
					continue;
				}
				
				if(visited[nx][ny]) continue;
				if(cheese[nx][ny] == 0) {
					que.offer(new Pair(nx, ny));
					visited[nx][ny] = true;
				}
				
				
			}
		
		}
		
//		for(int row = 0; row<ROW; row++) {
//			for(int col = 0; col < COL; col++) {
//				System.out.print(cheese[row][col] + " ");
//				
//			}
//			System.out.println();
//		}
//		
		return boundary;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. ROW, COL 값을 입력받는다.
		st = new StringTokenizer(br.readLine().trim());
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		
		// 2. cheese를 입력받는다.
		cheese = new int[ROW][COL];
		nextCheese = new int[ROW][COL];
		for(int row = 0; row < ROW; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int col = 0; col < COL; col++) {
				cheese[row][col] = Integer.parseInt(st.nextToken());
				if(cheese[row][col] == 1) preCheese++;
			}
		}
		
		int hour = 0;
		while(true) {
			preCheese -= boundary();
			
			hour++;
			if(preCheese == 0) {
				count();
				break;
			}
			reset();
		}
		System.out.println(hour);
		System.out.println(lastCheese);
		
	}




}
