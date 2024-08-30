import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1. 배열의 크기를 입력받는다
// 2. 지도의 정보를 입력받는다
// 3. 각 행의 첫번째 열에서 시작한다
// 3-3. 현재 열이 마지막 열이면  파이프라인 값을 하나 더하고, 리턴한다.
// 3-1. 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래를 탐색한다
// 3-2. 다음 값이 X 이면 리턴한다.
// 3-3. 가능한 자리에 파이프를 놓고(X로 변환한다) 다음 재귀를 호출한다


 
public class Main {
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int ROW;
    static int COL;
    static char map[][];
    static int dx[] = {-1, 0, 1};
    static int dy[] = {1, 1, 1};
    static int pipeline;
    
    public static boolean pipe(int row, int col) {
    	
    	// 3-3. 현재 열이 마지막 열이면  파이프를 설치하고, 리턴한다.
    	if(col == COL-1) {
    		map[row][col] = 'x';
    		return true;
    	}
    	
    	
    	boolean isComplete = false;
    	map[row][col] = 'x';
    	// 3-1. 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래를 탐색한다
    	// 3-2. 다음 값이 X이면 리턴한다.
    	// 오른쪽 대각선 위
    	if(row > 0 && !isComplete && map[row-1][col+1] != 'x') {
    		isComplete = pipe(row-1, col+1);
    		
    	} 
    	// 오른쪽
    	if(!isComplete && map[row][col+1] != 'x') {
    		isComplete = pipe(row, col+1);
    	} 
    		
    	// 오른쪽 대각선 아래
    	if(row < ROW-1 &&!isComplete &&  map[row+1][col+1] != 'x') {
    		isComplete = pipe(row+1, col+1);
    	} 
    	
    	//if(!isComplete) {map[row][col] = '.';}
    	return isComplete;
    }
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        
	    // 1. 배열의 크기를 입력받는다
        st = new StringTokenizer(bf.readLine().trim());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());
        
	    // 2. 지도의 정보를 입력받는다
        map = new char[ROW][COL];
        for(int row = 0; row <ROW; row++) {
        	String line =bf.readLine().trim();
        	for(int col = 0; col<COL; col++) {
        		map[row][col] = line.charAt(col);
        	}
        }
        
        for(int row = 0; row < ROW; row++) {
        
        	boolean isComplete = pipe(row, 0);
        	if(isComplete) pipeline++;
        }
        
        
        
        System.out.println(pipeline);
        
    }
}