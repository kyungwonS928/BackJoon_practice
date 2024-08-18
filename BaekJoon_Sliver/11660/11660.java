import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

// 1. 수의 개수와 합을 구해야하는 횟수를 입력받는다
// 2. N 크기 배열에 들어갈 수를 입력받는다
// 3. 배열을 입력받으면서 누적합을 구한다
// 3-1. 2차원 배열에서의 누적합은 num[row][col-1] + num[row-1][col] + element - num[row-1][col-1]이다
// 4. 합을 구해야하는 구간(start_row, start_col, end_row, end_col)을 M번 입력받는다
// 5. 원하는 구간에 대한 누적합은 num[row][col] - num[row-2][col] - num[row][col-2] + num[row-2][col-2]이다

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;
	static int cnt;
	static int num_cnt;
	static int num[][];

	public static void main(String[] args) throws NoSuchElementException, IOException {
		// TODO Auto-generated method stub
		bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		// 1. 수의 개수와 합을 구해야하는 횟수를 입력받는다
		st = new StringTokenizer(bf.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		num_cnt = Integer.parseInt(st.nextToken());
		// 2. N*N 크기 배열에 들어갈 수를 입력받는다
		num = new int[cnt+1][cnt+1];
		// 3. 배열을 입력받으면서 누적합을 구한다
        // 3-1. 2차원 배열에서의 누적합은 num[row][col-1] + num[row-1][col] + element - num[row-1][col-1]이다
		for(int row = 1; row<cnt+1; row++) {
			st = new StringTokenizer(bf.readLine().trim());
			for(int col = 1; col < cnt+1; col++) {
				int element = Integer.parseInt(st.nextToken());
				num[row][col] = num[row-1][col] + num[row][col-1] + element - num[row-1][col-1];
			}
		}
		
		// 4. 합을 구해야하는 구간(start_row, start_col, end_row, end_col)을 M번 입력받는다
		while(num_cnt-- > 0) {
			st = new StringTokenizer(bf.readLine().trim());
			int start_row = Integer.parseInt(st.nextToken());
			int start_col = Integer.parseInt(st.nextToken());
			int end_row = Integer.parseInt(st.nextToken());
			int end_col = Integer.parseInt(st.nextToken());
			// 5. 구하고자 하는 합의 크기가 2*2이므로,
			// 5-1. 원하는 구간에 대한 누적합은 num[end_row][end_col] - num[start_row-1][end_col] - num[end_row][start_col-1] + num[start_row-1][start_col-1]이다
			sb.append(num[end_row][end_col] - num[start_row-1][end_col] - num[end_row][start_col-1] + num[start_row-1][start_col-1]);
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}
}
