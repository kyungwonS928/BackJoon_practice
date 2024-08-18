import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;
	static int cnt;
	static int sum_cnt;
	static int num[];

	public static void main(String[] args) throws NoSuchElementException, IOException {
		// TODO Auto-generated method stub
		bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(bf.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		sum_cnt = Integer.parseInt(st.nextToken());
		num = new int[cnt+1];
		num[0] = 0;
		
		
		st = new StringTokenizer(bf.readLine().trim());
		for(int idx = 1; idx < cnt+1; idx++) {
			int element = Integer.parseInt(st.nextToken());
			
			
			num[idx] += num[idx-1] + element; 
		}
		
	
		
		while(sum_cnt-- >0) {
			st = new StringTokenizer(bf.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(num[end] - num[start-1]);
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}
