
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static int cnt;
	static int value;
	static int limit;
	// 무게, 가치 순서
	static int bag[][];
	static int dp[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 bf = new BufferedReader(new InputStreamReader(System.in));
		
		// StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		st = new StringTokenizer(bf.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());
		
		bag = new int[cnt][2];
		for(int idx = 0; idx < cnt; idx++) {
			st = new StringTokenizer(bf.readLine().trim());
			bag[idx][0] = Integer.parseInt(st.nextToken());
			bag[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[limit+1];
		for(int idx = 0; idx < cnt; idx++) {
			for(int cal = limit; cal >= bag[idx][0]; cal--) {
				dp[cal] = Math.max(dp[cal], dp[cal - bag[idx][0]] + bag[idx][1]);
			}
		}
		
		System.out.println(dp[limit]);
	}

}
