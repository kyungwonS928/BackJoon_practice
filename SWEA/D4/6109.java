import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
// 1. 배열의 크기와 어느 방향으로 밀건지 방향을 입력받는다.
// 2. 배열의 정보를 입력받는다.
// 3. 2048 게임을 한다.
// 3-1. 입력받은 방향에 따라 케이스를 나눈다.
// 3-2. 반복문을 돌며, 순서대로 0이 아닌 값을 List에 넣는다
// 3-3. 리스트 내에서 현재값과 다음값이 같으면 앞쪽 값에 * 2를 하고 뒤의 값은 삭제한다.
// 3-4. 리스트의 길이가 size 보다 작으면 부족한 만큼 0으로 채운다.
// 3-5. 다시 board에 적용한다.
// 배열을 출력한다.
  
public class Solution {
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int board[][];
    static int size;
    static String dir = new String("");
     
    public static void game() {
        if(dir.equals("up")) {
            for(int col = 0; col < size; col++) {
                List<Integer> temp = new ArrayList<>();
                 
                for(int row = 0; row<size; row++) {
                    if(board[row][col] != 0) temp.add(board[row][col]);
                }
                 
                for(int idx = 0; idx <temp.size()-1; idx++) {
                    if(temp.get(idx).equals(temp.get(idx+1))) {
                        temp.set(idx, temp.get(idx) *2);
                        temp.remove(idx+1);
                    }
                }
                 
                while(temp.size() != size) {
                    temp.add(0);
                }
                 
                for(int row = 0; row<size; row++) {
                    board[row][col] = temp.get(row);
                }
            }
             
        } else if(dir.equals("down")) {
             
            for(int col = 0; col < size; col++) {
                List<Integer> temp = new ArrayList<>();
                 
                for(int row = size-1; row>= 0; row--) {
                    if(board[row][col] != 0) temp.add(board[row][col]);
                }
                 
                for(int idx = 0; idx <temp.size()-1; idx++) {
                    if(temp.get(idx).equals(temp.get(idx+1))) {
                        temp.set(idx, temp.get(idx) *2);
                        temp.remove(idx+1);
                    }
                }
                 
                while(temp.size() != size) {
                    temp.add(0);
                }
                 
                for(int row = size-1; row>=0; row--) {
                    board[row][col] = temp.get(size-1-row);
                }
            }
             
        } else if(dir.equals("right")) {
            for(int row = 0; row < size; row++) {
                List<Integer> temp = new ArrayList<>();
                 
                for(int col = size-1; col >= 0; col--) {
                    if(board[row][col] !=0) temp.add(board[row][col]);
                }
                 
                for(int idx = 0; idx <temp.size()-1; idx++) {
                    if(temp.get(idx).equals(temp.get(idx+1))) {
                        temp.set(idx, temp.get(idx) *2);
                        temp.remove(idx+1);
                    }
                }
                 
                while(temp.size() != size) {
                    temp.add(0);
                }
                 
                for(int col = size-1; col>=0; col--) {
                    board[row][col] = temp.get(size-1-col);
                }
            }
             
             
        } else if(dir.equals("left")) {
            for(int row = 0; row < size; row++) {
                List<Integer> temp = new ArrayList<>();
                 
                for(int col = 0; col < size; col++) {
                    if(board[row][col] !=0) temp.add(board[row][col]);
                }
                 
                for(int idx = 0; idx <temp.size()-1; idx++) {
                    if(temp.get(idx).equals(temp.get(idx+1))) {
                        temp.set(idx, temp.get(idx) *2);
                        temp.remove(idx+1);
                    }
                }
                 
                while(temp.size() != size) {
                    temp.add(0);
                }
                 
                for(int col = 0; col<size; col++) {
                    board[row][col] = temp.get(col);
                }
            }
        }
    }
       
      
    public static void main(String[] args) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int Test = Integer.parseInt(bf.readLine().trim());
          
        for(int tcase = 1; tcase <= Test; tcase++) {
     
            // 1. 배열의 크기와 어느 방향으로 밀건지 방향을 입력받는다.
            st = new StringTokenizer(bf.readLine().trim());
            size = Integer.parseInt(st.nextToken());
            dir = st.nextToken();
             
            // 2. 배열의 정보를 입력받는다.
            board = new int[size][size];
            for(int row = 0; row<size; row++) {
                st = new StringTokenizer(bf.readLine().trim());
                for(int col = 0; col<size; col++) {
                    board[row][col] = Integer.parseInt(st.nextToken());
                }
            }
             
            game();
             
            sb.append("#" + tcase + "\n");
            for(int row = 0; row<size; row++) {
                for(int col = 0; col<size; col++) {
                    sb.append(board[row][col] + " ");
                }
                sb.append('\n');
            }
             
        }
          
        System.out.println(sb.toString());
    }
}
