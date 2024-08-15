package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//1. 도시의 크기와 남길 치킨집의 개수를 입력받는다
//2. 도시의 배열을 입력받는다.
//2-1. 치킨집의 위치를 저장한다
//3. 치킨집의 조합을 만든다
//3-1. 부분집합의 원소가 M개가 되면 집합이 되는 것을 멈추고 최소 치킨거리를 구한다
//4. 치킨거리는 하나의 집에서 가장 가까운 치킨집과의 거리이다
//4-1. 해당 치킨집이 선택되었을 때 모든 집과의 거리를 구한다


public class Main {
    static BufferedReader bf;
    static StringTokenizer st;
    static int[][] city;
    static int size;
    static int chicken;
    static boolean[] remainChicken;
    static List<Pair> chicken_store = new ArrayList<>();
    static List<Pair> house = new ArrayList<>();
    static class Pair{
        int x;
        int y;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int min_street = 987654321;


    public static void powerSet(int elementIdx, int cnt) {
        //3-1. 부분집합의 원소가 M개가 되면 집합이 되는 것을 멈추고 최소 치킨거리를 구한다
        if(elementIdx == chicken_store.size()) {
            if(cnt <= chicken) {
                int cur_street = 0;
                //4. 치킨거리는 하나의 집에서 가장 가까운 치킨집과의 거리이다
                //4-1. 해당 치킨집이 선택되었을 때 모든 집과의 거리를 구한다
                for(int houseIdx = 0; houseIdx < house.size(); houseIdx++) {
                    int min_dist = 251;
                    for(int chickenIdx = 0; chickenIdx < chicken_store.size(); chickenIdx++) {
                        if(remainChicken[chickenIdx]) {
                            int cur_dist = Math.abs(chicken_store.get(chickenIdx).x - house.get(houseIdx).x) + Math.abs(chicken_store.get(chickenIdx).y - house.get(houseIdx).y);
                            min_dist = Math.min(min_dist, cur_dist);
                        }
                    }
                    cur_street += min_dist;
                }
                min_street = Math.min(cur_street, min_street);
            }

            return;
        }

        remainChicken[elementIdx] = true;
        powerSet(elementIdx+1, cnt+1);

        remainChicken[elementIdx] = false;
        powerSet(elementIdx+1, cnt);
    }


    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        //1. 도시의 크기와 남길 치킨집의 개수를 입력받는다

        st = new StringTokenizer(bf.readLine());
        size = Integer.parseInt(st.nextToken());
        chicken = Integer.parseInt(st.nextToken());

        //2. 도시의 배열을 입력받는다.
        city = new int[size][size];
        for(int row = 0; row<size; row++){
            st = new StringTokenizer(bf.readLine());
            for(int col = 0; col<size; col++){
                city[row][col] = Integer.parseInt(st.nextToken());
                if(city[row][col] == 2) {
                    chicken_store.add(new Pair(row, col));
                } else if(city[row][col] == 1) {
                    house.add(new Pair(row, col));
                }
            }
        }

        //3. 치킨집의 부분집합을 만든다
        remainChicken = new boolean[chicken_store.size()];
        powerSet(0, 0);

        System.out.println(min_street);

    }
}
