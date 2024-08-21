import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 배열의 크기, r행, c행을 입력받는다.
// 2. 재귀를 돌며 이동 횟수를 계산한다.
// 2-1. 탐색하는 칸이 Z의 어디에 있는지에 따라 계산 한다.
// 3. 몇번째로 방문했는지 출력한다.
 
public class Main {
    static BufferedReader bf;
    static StringTokenizer st;
    static int size;
    static int map[][];
    static int endRow;
    static int endCol;
    
    public static int recursive(int arrSize, int row, int col) {
    	if (arrSize == 0)
    		return 0;
    	
    	
    	// 2^(arrSize-1) -> 현재 Z 모양이 시작하는 위치
    	int half = 1 << (arrSize - 1);
    	// Z 의 첫번째 위치에 있을 떄
    	if (row < half && col < half)
    		return recursive(arrSize - 1, row, col);
    	// Z 의 두번째 위치에 있을 떄
    	if (row< half && col >= half)
    		return half * half + recursive(arrSize - 1, row, col - half);
    	// Z 의 세번째 위치에 있을 떄 
    	if (row>= half && col < half)
    		return 2 * half * half + recursive(arrSize - 1, row - half, col);
    	// Z 의 네번째 위치에 있을 때
    	return 3 * half * half + recursive(arrSize - 1, row- half, col - half);
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(bf.readLine());
        
        size = Integer.parseInt(st.nextToken());
        endRow = Integer.parseInt(st.nextToken());
        endCol = Integer.parseInt(st.nextToken());
        
        System.out.println(recursive(size, endRow, endCol));
       
    }
}
