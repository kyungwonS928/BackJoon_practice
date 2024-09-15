import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int num;         // 학생 수
    static int[] team;      // 각 학생이 선택한 팀
    static boolean[] visited;   // 방문 여부 체크
    static boolean[] done;      // 탐색 완료 여부 체크
    static int set;             // 팀을 이루는 학생 수

    public static void dfs(int n) {
        visited[n] = true;
        int next = team[n];   // 다음 학생을 선택

        // 다음 학생이 아직 방문하지 않았으면 dfs 탐색
        if (!visited[next]) {
            dfs(next);
        }
        // 다음 학생이 방문했지만, 아직 완료되지 않았다면 사이클을 형성
        else if (!done[next]) {
            // 사이클이 형성된 경우, 팀 인원 수 세기
            for (int i = next; i != n; i = team[i]) {
                set++;   // 사이클을 이루는 학생들 카운트
            }
            set++;   // 자기 자신도 포함
        }

        // 탐색 완료 표시
        done[n] = true;
    }

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int Test = Integer.parseInt(br.readLine());  // 테스트케이스 수

        for (int tcase = 1; tcase <= Test; tcase++) {
            set = 0;  // 팀을 이룬 학생 수 초기화
            num = Integer.parseInt(br.readLine());  // 학생 수 입력

            team = new int[num + 1];    // 각 학생이 선택한 팀 정보 저장
            visited = new boolean[num + 1];   // 방문 여부
            done = new boolean[num + 1];   // 탐색 완료 여부

            st = new StringTokenizer(br.readLine());
            for (int idx = 1; idx <= num; idx++) {
                team[idx] = Integer.parseInt(st.nextToken());  // 학생이 선택한 팀원 정보 입력
            }

            // 모든 학생에 대해 DFS 탐색
            for (int idx = 1; idx <= num; idx++) {
                if (!visited[idx]) {
                    dfs(idx);   // 방문하지 않은 학생에 대해 DFS 수행
                }
            }

            // 전체 학생 수에서 팀을 이룬 학생 수를 빼서 결과 출력
            System.out.println(num - set);
        }
    }
}
