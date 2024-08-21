import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 배열의 크기를 입력받는다.
// 2. 영상 정보를 입력받는다.
// 3. 영상을 압축한다.
// 3-1. 주어진 배열을 4등분한다.
// 3-2. 배열 내의 모든 영상 정보가 동일하면 해당 값으로 영상을 압축한다.
// 3-3. 그렇지 않다면, 배열의 크기를 1/4로 줄여서 다시 확인한다.
 
public class Main {
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int size;
    static int video[][];
    static String compression;
    
    public static void recursive(int row, int col, int arrSize) {
    	if (arrSize == 0) {
    		return;
    	}
    	
    	int sum = 0;
		// 면적 내의 모든 값들의 합으로 확인
		for(int curRow = row, rEnd = row+arrSize; curRow < rEnd; curRow++ ) {
			for(int curCol = col, cEnd = col+arrSize; curCol < cEnd; curCol++) {
				sum += video[curRow][curCol];
			}
		}
	
		
		
		// 3-2. 배열 내의 모든 영상 정보가 동일하면 해당 값으로 영상을 압축한다.
		if(sum == 0) { //기저조건
			sb.append("0");
			
		} else if(sum == arrSize*arrSize) { //기저조건
			
			sb.append("1");
			
		}
		// 3-3. 그렇지 않다면, 배열의 크기를 1/4로 줄여서 다시 확인한다.
		else {
			sb.append("(");
			int half = arrSize/2;
			recursive(row, col, half);
			recursive(row, col+half, half);
			recursive(row+half, col, half);
			recursive(row+half, col+half, half);

			sb.append(")");
		}
    	
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        
        
        size = Integer.parseInt(bf.readLine().trim());
        video = new int[size][size];
        sb = new StringBuilder();
        for(int row = 0; row<size; row++) {
        	String line = bf.readLine().trim();
        	for(int col = 0; col<size; col++) {
        		video[row][col] = line.charAt(col) - '0';
        	}
        }
        
        
        recursive(0,0,size);

        System.out.println(sb.toString());
    }
}
