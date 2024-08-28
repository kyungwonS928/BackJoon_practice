import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 게임규칙
//궁수
// 1. 궁수는 동시에 공격한다.
// 2. 궁수는 하나의 적만 쓰러트릴수 있다.
// 3. 거리가 D 이하인 적 중에서 가장 가까운 적을 공격할 수 있다. |r1-r2| + |c1-c2|
// 4. 공격당한 적은 게임에서 없어진다.
// 적
// 1. 적은 계속 아래로 한칸식 내려간다.
// 2. 적이 모두 내려가서 격자판의 범위를 벗어나면(N+1)이 되면 게임이 끝난다.


// 1. 격자 크기와, 궁수의 공격거리를 입력받는다.
// 1-1. map의 크기는 [N+1][M]으로해서 궁수 위치를 생각한다.
// 2. 적의 위치를 입력받는다.(적은 1)
// 3. col의 값 중, 궁수가 있는 값 3개를 뽑는다(조합 max: 15C3)
// 4. 궁수가 공격한다.
// 4-1. 각 궁수마다 가장 가까운 적을 구해서 공격한다.
// 		궁수를 기준으로 작은 마름모 모양으로 탐색한다.
//		가장 왼쪽에 있는 값을 finish 리스트에 넣는다.
// 		
// 4-2. 공격이 끝나면 궁수를 위로 한칸 올린다.
// 5. 최대 죽일 수 있는 적의 수를 구한다.


public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int ROW;
	static int COL;
	static int attackDist;
	static int map[][];
	static int tempMap[][];
	static int maxAttack;
	static int archer[] = new int[3];
	static int dx[] = {0, 0, -1};
	static int dy[] = {1, -1, 0};
	static class Pair{
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static List<Pair> sameDist = new ArrayList<>();
	static List<Pair> finish = new ArrayList<>();
	
	
	public static void defence() {
		int attackCounter = 0;
		for(int archerRow = ROW; archerRow > 0; archerRow--) {
			for(int archerIdx = 0; archerIdx < 3; archerIdx++) {
				int curArcher = archer[archerIdx];
				for(int dist = 1; dist <= attackDist; dist++) {
					boolean isAttack = false;
					
					
					for(int row = archerRow-1; row >= archerRow-dist; row--) {
						for(int col = curArcher - dist +1; col < curArcher + dist; col++) {
							if(row < 0 || col < 0 || col >= COL) continue;
							if(Math.abs(row - archerRow) + Math.abs(col - archer[archerIdx]) == dist && tempMap[row][col] == 1) {
								isAttack = true;
								sameDist.add(new Pair(row, col));
								break;
							}
							
						}
					}
					
					
					//가장 왼쪽에 있는 적 찾기
					if(isAttack) {
						if(sameDist.size() > 1) {
							sameDist.sort((first, second) -> Integer.compare(first.y, second.y));
						}
						
						finish.add(sameDist.get(0));
						
						sameDist.clear();
						break;
					}
				}
			}
			
			if(finish.size() > 0) {
				
				for(int idx = 0; idx < finish.size(); idx++ ) {
					if(tempMap[finish.get(idx).x][finish.get(idx).y] == 1) attackCounter++;
					tempMap[finish.get(idx).x][finish.get(idx).y] = 0;
				}
				finish.clear();
//				for(int row = 0; row < archerRow; row++) {
//					for(int col = 0; col < COL; col++) {
//						System.out.print(tempMap[row][col] + " ");
//					}
//					System.out.println();
//				}
			}
			
			
		}
//		for(int idx = 0; idx < 3; idx++) {
//			System.out.print("archer " + archer[0] + archer[1] + archer[2]);
//		}
//		System.out.println();
//		System.out.println("max" + attackCounter);
		
		if(attackCounter > maxAttack) {
			
			maxAttack = attackCounter;
		}
		
	}
	
	public static void combination(int elementIdx, int selectIdx) {
		if(selectIdx == 3) {
			for(int row = 0; row <= ROW; row++) {
				tempMap[row] = map[row].clone();
			}
//			for(int idx = 0; idx < 3; idx++) {
//				System.out.print(archer[idx] + " ");
//			}
//			System.out.println();
			
			defence();
			return;
		}
		
		if(elementIdx == COL) return;
		
		archer[selectIdx] = elementIdx;
		combination(elementIdx + 1, selectIdx +1);
		combination(elementIdx + 1, selectIdx);
	}
	
		
	public static void main(String[] args) throws IOException {
		maxAttack = 0;
		br = new BufferedReader(new InputStreamReader(System.in));
		// 1. 격자 크기와, 궁수의 공격거리를 입력받는다.
		st = new StringTokenizer(br.readLine().trim());
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		attackDist = Integer.parseInt(st.nextToken());
		
		// 1-1. map의 크기는 [N+1][M]으로해서 궁수 위치를 생각한다.
		map = new int[ROW+1][COL];
		tempMap = new int[ROW+1][COL];
		// 2. 적의 위치를 입력받는다.(적은 1)
		for(int row = 0; row < ROW; row++) { 
			st = new StringTokenizer(br.readLine().trim());
			for(int col = 0; col < COL; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		combination(0, 0);
		System.out.println(maxAttack);
		
		
		
	}



}
