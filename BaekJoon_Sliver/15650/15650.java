import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

// 1. N과 M을 입력받는다
// 2. 1부터 N 까지의 자연수 중에서 중복 없이 M개를 고른 순열이면서, M개가 오름차순을 이뤄야한다
// 2-1. 조합으로 문제를 해결한다
// 2-2. 모든 자연수를 확인하고 선택했다면 return 한다
// 2-3. 아직 선택하지 않은 원소를 선택하고 다음 재귀를 호출한다
// 2-4. 아직 선택하지 않은 원소를 선택하지 않고 다음 재귀를 호출한다.

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int arraySize, pickNum;
	static int[] element;
	static int[] selectElement;
	static boolean[] elementUsed;
	
	public static void combination(int elementIdx, int selectIdx) {
		
		
		// 2-2. 모든 자연수를 선택했다면 return 한다
		
		if(selectIdx == pickNum) {
			for(int idx = 0; idx < selectIdx; idx++) {
				sb.append(selectElement[idx] + " ");
			}
			sb.append('\n');
			return;
		}
		
		
		// 2-2. 모든 자연수를 확인했다면 return한다
		if(elementIdx == arraySize) return;
		

		// 2-3. 아직 선택하지 않은 원소를 선택하고 다음 재귀를 호출한다
		selectElement[selectIdx] = element[elementIdx];
		combination(elementIdx + 1, selectIdx+1);
		// 2-4. 아직 선택하지 않은 원소를 선택하지 않고 다음 재귀를 호출한다.
		
		selectElement[selectIdx] = 0;
		combination(elementIdx +1, selectIdx);
		
		
	}

	public static void main(String[] args) throws NoSuchElementException, IOException {
		// TODO Auto-generated method stub
		bf = new BufferedReader(new InputStreamReader(System.in));
		
		
			st = new StringTokenizer(bf.readLine().trim());
			
			arraySize = Integer.parseInt(st.nextToken());
			pickNum = Integer.parseInt(st.nextToken());
			
			
			element = new int[arraySize];
			for(int idx = 0; idx < arraySize; idx++) {
				element[idx] = idx+1;
			}
			
			selectElement = new int[pickNum];
			elementUsed = new boolean[arraySize];
			
			
			combination(0, 0);
			
			
			System.out.println(sb.toString());
			
	}

}
