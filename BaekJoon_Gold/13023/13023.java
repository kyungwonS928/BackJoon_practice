import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1. 사람의 수와 친구 관계의 수를 입력받는다.
// 2. 친구 관계에 있는 사람 번호를 입력받는다.
// 2-1. 입력받은 사람 번호로 무향 그래프를 만든다.
// 3. 그래프를 탐색한다.
// 3-1. 지나온 사람이 5명이면 1을 출력한다.
// 3-2. 현재 사람과 관계를 맺고 있는 사람이 있으면 다음 사람으로 넘어간다.
// 4. 결과를 출력한다.

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static List<Integer> people[];
	static int peopleCnt;
	static int relationCnt;
	static int result;
	static boolean visited[];
	
	
	public static void countRelation(int num, int cnt) {
		// 3-1. 지나온 사람이 5명이면 1을 출력한다. -> 간선은 4개
		if(cnt == 4) {
			result = 1;
			return;
		}
		
		for(int idx = 0; idx < people[num].size(); idx++) {
			// 3-2. 현재 사람과 관계를 맺고 있는 사람이 있으면 다음 사람으로 넘어간다.
			if(!visited[people[num].get(idx)]) {
				visited[people[num].get(idx)] = true;
				countRelation(people[num].get(idx), cnt+1);
				visited[people[num].get(idx)] = false;
			}
			
		}
		
	}


	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		// 1. 사람의 수와 친구 관계의 수를 입력받는다.
		st = new StringTokenizer(br.readLine().trim());
		peopleCnt = Integer.parseInt(st.nextToken());
		relationCnt = Integer.parseInt(st.nextToken());
		
		people = (ArrayList<Integer>[]) new ArrayList[peopleCnt];
		visited = new boolean[peopleCnt];
		
		for(int idx = 0; idx < peopleCnt; idx++) {
			people[idx]= new ArrayList<Integer>();
		}

		// 2. 친구 관계에 있는 사람 번호를 입력받는다.
		for(int idx = 0; idx < relationCnt; idx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			// 2-1. 입력받은 사람 번호로 무향 그래프를 만든다.
			people[first].add(second);
			people[second].add(first);
		}
		
		// 3. 그래프를 탐색한다.
		for(int idx = 0; idx < peopleCnt; idx++) {
			visited[idx] = true;
			countRelation(idx, 0);
			visited[idx] = false;
			if(result == 1) break;
		}
		
		
		System.out.println(result);
	}

}
