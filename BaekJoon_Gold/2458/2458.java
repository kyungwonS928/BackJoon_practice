import java.io.*;
import java.util.*;

// 아이디어: 나보다 키가 작은 사람의 수 + 나보다 키가 큰 사람의 수 = 전체 학생수 -1

// 1. 학생수를 입력받는다
// 2. 학생들의 키 순서 관계 개수를 입력받는다.
// 3. 키가 작은 사람, 큰 사람 순서로 값을 입력받는다.
// 4. 인접 리스트 2개를 만든다
// 4-1. 첫번째는 idx 번호에서 원소 값으로 진출하는 것을 나타내고
// 4-2. 두번째는 다른 번호에서 해당 idx로 진입하는 것을 나타낸다.
// 4-3. 예를 들어 entry[4].size() 는 4번학생보다 작은 키의 학생수를 나타내고, exit[4].size()는 4번학생보다 큰 학생 수를 나타낸다.
// 5. 전체 학생수를 돌면서 키 순서를 정할 수 있는 학생 수를 구한다
// 5-1. 현재 학생보다 작은 모든 학생을 찾는다(순서가 확정된)
//      현재 학생으로 진출하는 학생으로 진출하는 학생으로 진출하는....
// 5-2. 현재 학생보다 큰 모든 학생을 찾늗다.
//      현재 학생에서 진출하여 만나는 학생에서 진출하여 만나는 학생에서 진출하여 만나는...
// 5-3. 현재 학생보다 키가 작은 학생과 키가 큰 학생의 합이 전체에서 현재 학생수를 제외한 수라면 순서가 확정된 것이다.
// 6. 최종 학생 수를 출력한다.

public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int student;
    static int heightCnt;
    static List<Integer> entry[];
    static List<Integer> exit[];
    static int knowOrder;
    static boolean visited[];
    static int sum;


    public static void findEntry(int cur) {
        //      현재 학생으로 진출하는 학생으로 진출하는 학생으로 진출하는....
        visited[cur] = true;
        for (int next : entry[cur]) {
            if (!visited[next]) {
                sum++;
                findEntry(next);
            }
        }
    }

    public static void findExit(int cur) {
        //      현재 학생에서 진출하여 만나는 학생에서 진출하여 만나는 학생에서 진출하여 만나는...
        visited[cur] = true;
        for (int next : exit[cur]) {
            if (!visited[next]) {
                sum++;
                findExit(next);
            }
        }
    }

    public static void checkOrder() {
        for (int idx = 1; idx <= student; idx++) {
            sum = 0;
            // 5-1. 현재 학생보다 작은 모든 학생을 찾는다(순서가 확정된)
            visited = new boolean[student + 1];
            findEntry(idx);

            // 5-2. 현재 학생보다 큰 모든 학생을 찾늗다.
            visited = new boolean[student + 1];
            findExit(idx);

            // 5-3. 현재 학생보다 키가 작은 학생과 키가 큰 학생의 합이 전체에서 현재 학생수를 제외한 수라면 순서가 확정된 것이다.
            if (sum == student - 1) {
                knowOrder++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
            knowOrder = 0;

            st = new StringTokenizer(bf.readLine());
            // 1. 학생수를 입력받는다
            student = Integer.parseInt(st.nextToken());

            // 2. 학생들의 키 순서 관계 개수를 입력받는다.
            heightCnt = Integer.parseInt(st.nextToken());


            entry = new ArrayList[student + 1];
            exit = new ArrayList[student + 1];
            for (int idx = 1; idx <= student; idx++) {
                entry[idx] = new ArrayList<>();
                exit[idx] = new ArrayList<>();
            }


            for (int idx = 0; idx < heightCnt; idx++) {
                // 3. 키가 작은 사람, 큰 사람 순서로 값을 입력받는다.
                st = new StringTokenizer(bf.readLine());
                int small = Integer.parseInt(st.nextToken());
                int tall = Integer.parseInt(st.nextToken());

                // 4. 인접 리스트 2개를 만든다
                // 4-1. 첫번째는 idx 번호에서 원소 값으로 진출하는 것을 나타내고
                exit[small].add(tall);
                // 4-2. 두번째는 다른 번호에서 해당 idx로 진입하는 것을 나타낸다.
                entry[tall].add(small);
            }

            // 5. 전체 학생수를 돌면서 키 순서를 정할 수 있는 학생 수를 구한다
            checkOrder();

            // 6. 최종 학생 수를 출력한다.
            System.out.println(knowOrder);


    }
}