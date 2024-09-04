import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 1. 학생 수(정점)와, 키를 비교한 횟수(간선)를 입력받는다
// 2. 키를 비교한 학생을 작은 학생, 큰 학생 순서로 반복해서 입력받는다.
// 2-1. 키가 작은 학생의 인접 노드로 큰 학생을 추가한다.
// 2-2. 키가 큰 학생의 진입 차수를 증가시킨다.
// 3. 진입차수가 0인 학생 번호를 que에 넣는다
// 4. 큐가 빌때까지
// 4-1. 현재 값을 출력하고
// 4-2. 현재 값의 인접 노드의 진입 차수를 하나 줄인다.
// 4-3. 만약 0이 된 노드가 있다면 큐에 삽입한다.
// 5. 결과를 출력한다.


public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int student;
	static int edge;
	
	
	// 그래프 입력
	static List<Integer> adj[];
	// 진입 차수 개수
	static int pre[];
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		// 1. 학생 수(정점)와, 키를 비교한 횟수(간선)를 입력받는다
		
		st = new StringTokenizer(br.readLine().trim());
		student = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		
		adj = (ArrayList<Integer>[]) new ArrayList[student+1];
		pre = new int[student+1];
	
		for (int i=0; i<=student; i++) {
		    adj[i] = new ArrayList<Integer>();
		}
		
		
		// 2. 키를 비교한 학생을 작은 학생, 큰 학생 순서로 반복해서 입력받는다.	
		while(edge-->0) {
			st = new StringTokenizer(br.readLine().trim());
			int first, second;
			
			// 2-1. 키가 작은 학생의 인접 노드로 큰 학생을 추가한다.
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			
			// 2-2. 키가 큰 학생의 진입 차수를 증가시킨다.
			adj[first].add(second);
			pre[second]++;
		}
		
		
		// 3. 진입차수가 0인 학생 번호를 que에 넣는다
		Queue<Integer> que = new ArrayDeque<>();
		for(int i = 1;i<=student;i++) {
			if(pre[i] == 0) que.offer(i);
		}
		
		// 4. 큐가 빌때까지
		while(!que.isEmpty()) {
			// 4-1. 현재 값을 출력하고
			int cur = que.poll();
			sb.append(cur + " ");
			for(int nxt : adj[cur]) {
				// 4-2. 현재 값의 인접 노드의 진입 차수를 하나 줄인다.
				pre[nxt]--;
				// 4-3. 만약 0이 된 노드가 있다면 큐에 삽입한다.
				if(pre[nxt] == 0) que.offer(nxt);
			}
		}
		// 5. 결과를 출력한다.
		System.out.println(sb.toString());
	}



}
