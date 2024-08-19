import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//1. 재료의 개수를 입력받는다
// 2. 재료의 신맛과 쓴맛 정보를 입력받는다
// 3. 해당 재료가 포함될지 아닐지에 대한 부분집합을 구한다.
// 4. 요리가 완성되면 신맛과 쓴맛의 차이를 구한다.
// 4-1. 신맛끼리는 곱셈, 쓴맛끼리는 덧셈을 적용한다.
// 4-2. 신맛과 쓴맛의 차이가 가장 작은 요리를 업데이트한다.


public class Main {
	
	static BufferedReader bf;
	static StringTokenizer st;
	static int cnt;
	static int ingredient[][];
	static boolean selectIngredient[];
	static int bestTaste;
	
	
	
	public static void powerSet(int elementIdx, int sour, int bitter) {
		if(elementIdx == cnt) {
			if(sour == 1 && bitter == 0) return;
			int taste = Math.abs(sour - bitter);
			if(taste < bestTaste) bestTaste = taste;
			return;
		}
		
		selectIngredient[elementIdx] = true;
		powerSet(elementIdx+1, sour * ingredient[elementIdx][0], bitter + ingredient[elementIdx][1]);
		
		selectIngredient[elementIdx] = false;
		powerSet(elementIdx+1, sour, bitter);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		bestTaste = 987654321;
		bf = new BufferedReader(new InputStreamReader(System.in));
		// 1. 재료의 개수를 입력받는다
		cnt = Integer.parseInt(bf.readLine().trim());
		ingredient = new int [cnt][2];
		selectIngredient = new boolean[cnt];
		
		for(int idx = 0; idx < cnt; idx++) {
			st = new StringTokenizer(bf.readLine().trim());
			
			ingredient[idx][0] = Integer.parseInt(st.nextToken());
			ingredient[idx][1] = Integer.parseInt(st.nextToken());
			
		}
		
		powerSet(0, 1, 0);
					
		System.out.println(bestTaste);
	}

}
