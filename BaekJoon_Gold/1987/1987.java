import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1. ROW, COL 값을 입력받는다.
// 2. 지도 정보를 입력받는다.
// 3. dfs를 돌며 말이 갈수있는 경로를 확인한다.
// 3-1. 말은 (0, 0)에서 출발한다.
// 3-2. 상하좌우 각각 칸을 확인하여 아직 지나온 알파벳이 아니면 앞으로 간다.
// 3-3. 더이상 갈 수 없거나, 모든 알파벳을 다 지났으면 종료한다.



public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	static char map[][];
	static boolean alphabet[] = new boolean[26];
	static int ROW;
	static int COL;
	static int maxCnt;
	
	public static void dfs(int row, int col, int cnt) {
		if(row < 0 || row >= ROW || col < 0 || col >= COL) {
			return;
		}
		
		if(cnt == 27) {
			
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}
		
		
		if(row < ROW-1 && !alphabet[map[row+1][col] -'A']) {
			alphabet[map[row+1][col] -'A'] = true;
			dfs(row+1, col, cnt+1);
			alphabet[map[row+1][col] -'A'] = false;
		} 
		if(row > 0 && !alphabet[map[row-1][col] - 'A']) {
			alphabet[map[row-1][col] -'A'] = true;
			dfs(row-1, col, cnt+1);
			alphabet[map[row-1][col] -'A'] = false;
		}
		if(col < COL-1 && !alphabet[map[row][col+1] - 'A']) {
			alphabet[map[row][col+1] -'A'] = true;
			dfs(row, col+1, cnt+1);
			alphabet[map[row][col+1] -'A'] = false;
		}
		if(col > 0 &&!alphabet[map[row][col-1] - 'A']) {
			alphabet[map[row][col-1] -'A'] = true;
			dfs(row, col-1, cnt+1);
			alphabet[map[row][col-1] -'A'] = false;
		}
		
		if(maxCnt < cnt) {
			
			maxCnt = cnt;
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. ROW, COL 값을 입력받는다.
		st = new StringTokenizer(br.readLine().trim());
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		
		// 2. 지도 정보를 입력받는다.
		map = new char[ROW][COL];
		for(int row = 0; row<ROW; row++) {
			String line = br.readLine().trim();
			for(int col = 0; col<COL; col++) {
				map[row][col] = line.charAt(col);
			}
		}
		
		// 3. dfs를 돌며 말이 갈수있는 경로를 확인한다.
		alphabet[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(maxCnt);
		
	}

}
