import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int game[] = new int[18];
    static int team[] = new int[18];
    static Match match[] = new Match[15];
    static class Match{
        int first;
        int second;

        public Match(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static boolean isPossible;

    public static void checkScore(int turn) {
        if (isPossible) return;


        if(turn == 15) {
            for(int idx = 0; idx<18; idx++) {
                if(game[idx] != 0) {
                    isPossible = false;
                    return;
                }
            }
            isPossible = true;
            return;
        }

        int first  = match[turn].first;
        int second = match[turn].second;

        int firstWin = game[first*3];
        int secondLose = game[second*3 + 2];
        if(firstWin > 0 && secondLose >0) {
            game[first*3]--;
            game[second*3 + 2]--;
            checkScore(turn+1);
            game[first*3] ++;
            game[second*3 + 2]++;
        }

        int firstDraw = game[first*3 + 1];
        int secondDraw = game[second*3 + 1];
        if(firstDraw > 0 && secondDraw > 0) {
            game[first*3+1]--;
            game[second*3+1]--;
            checkScore(turn+1);
            game[first*3+1]++;
            game[second*3+1]++;
        }

        int firstLose = game[first*3 + 2];
        int secondWin = game[second*3];
        if(firstLose > 0 && secondWin > 0) {
            game[first*3+2]--;
            game[second*3]--;
            checkScore(turn+1);
            game[first*3+2]++;
            game[second*3]++;
        }

    }

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        for(int gameCase = 0; gameCase < 4; gameCase++) {
            isPossible = false;
            for(int idx = 0; idx<18; idx++) {
                team[idx] = 0;
            }

            st = new StringTokenizer(bf.readLine().trim());
            int sum = 0;
            for(int input = 0; input < 18; input++) {
                game[input] = Integer.parseInt(st.nextToken());
                sum += game[input];

            }

            if(sum != 30) {
                sb.append(0 + " ");
                continue;
            }

            int idx = 0;
            for(int first = 0; first < 5; first++) {
                for(int second = first+1; second < 6; second++) {
                    match[idx++] = new Match(first, second);
                }
            }


            checkScore(0);
            sb.append(isPossible ? 1 : 0).append(" ");
        }

        System.out.println(sb.toString());
    }
}
