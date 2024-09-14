import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1. 집의 개수를 입력받는다.
// 2. 각 집을 칠할때 비용을 입력받는다.
// 3. dp 풀이
// 3-1. 현재 집을 빨강/파랑/초록으로 칠하는 비용을 계산한다.
// 3-2. 예시로, 현재 집을 빨강으로 칠하기 위해서는 이전 집이 초록 또는 파랑으로 칠해져 있어야 하는데
// 3-3. 최소 비용을 구해야 하므로, 이전 집을 초록, 파랑으로 칠하는 것 중 최소값을 선택하고, 현재 집을 빨강으로 칠한다.
// 3-4. 마지막 집을 빨강, 초록, 파랑으로 칠하는 경우의 수 중 비용이 작은 것을 구한다.
// 4. 최소 비용을 출력한다.

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int houseCnt;
	static int coloring [][];
	static int color[][];
	
	public static void main(String args[]) throws IOException {
		br= new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		
		houseCnt = Integer.parseInt(br.readLine().trim());
		
		coloring = new int[houseCnt+1][3];
		for(int idx = 1; idx <= houseCnt; idx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			coloring[idx][0] = Integer.parseInt(st.nextToken());	//빨강
			coloring[idx][1] = Integer.parseInt(st.nextToken());	//초록
			coloring[idx][2] = Integer.parseInt(st.nextToken());	//파랑
		}
		
		
		
		
		// 3. dp 풀이
		color = new int[houseCnt+1][3];
		for(int idx = 1; idx <= houseCnt; idx++) {
			// 3-1. 현재 집을 빨강/파랑/초록으로 칠하는 비용을 계산한다.
			// 3-2. 예시로, 현재 집을 빨강으로 칠하기 위해서는 이전 집이 초록 또는 파랑으로 칠해져 있어야 하는데
			// 3-3. 최소 비용을 구해야 하므로, 이전 집을 초록, 파랑으로 칠하는 것 중 최소값을 선택하고, 현재 집을 빨강으로 칠한다.
			color[idx][0] = Math.min(color[idx-1][1], color[idx-1][2]) + coloring[idx][0];	//현재 집 빨강
			color[idx][1] = Math.min(color[idx-1][0], color[idx-1][2]) + coloring[idx][1];	//현재 집 초록
			color[idx][2] = Math.min(color[idx-1][0], color[idx-1][1]) + coloring[idx][2];	//현재 집 파랑
			
		}
		// 3-4. 마지막 집을 빨강, 초록, 파랑으로 칠하는 경우의 수 중 비용이 작은 것을 구한다.
		int minCost = Math.min(Math.min(color[houseCnt][0], color[houseCnt][1]), color[houseCnt][2]);
		
		System.out.println(minCost);
		
	}

	
}
