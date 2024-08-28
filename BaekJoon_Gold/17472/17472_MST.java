import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader bf;
    static StringTokenizer st;
    static int map[][];
    static int ROW;
    static int COL;
    static List<Edge> edges;
    static int[] parents;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parents[rootA] = rootB;
            return true;
        }
        return false;
    }

    public static void bfs(int startX, int startY, int islandIdx) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startX, startY));
        map[startX][startY] = islandIdx;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int x = current.x;
            int y = current.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < ROW && ny < COL && map[nx][ny] == 1) {
                    map[nx][ny] = islandIdx;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static void findEdges(int islandCount) {
        for (int x = 0; x < ROW; x++) {
            for (int y = 0; y < COL; y++) {
                if (map[x][y] > 0) { // 섬인 경우
                    int islandIdx = map[x][y];
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        int length = 0;

                        while (nx >= 0 && ny >= 0 && nx < ROW && ny < COL && map[nx][ny] == 0) {
                            length++;
                            nx += dx[dir];
                            ny += dy[dir];
                        }

                        if (nx >= 0 && ny >= 0 && nx < ROW && ny < COL && map[nx][ny] != islandIdx && map[nx][ny] > 0) {
                            if (length > 1) { // 길이가 2 이상인 다리만 유효
                                edges.add(new Edge(islandIdx, map[nx][ny], length));
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(bf.readLine().trim());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];
        for (int row = 0; row < ROW; row++) {
            st = new StringTokenizer(bf.readLine().trim());
            for (int col = 0; col < COL; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int islandIdx = 2;
        for (int x = 0; x < ROW; x++) {
            for (int y = 0; y < COL; y++) {
                if (map[x][y] == 1) {
                    bfs(x, y, islandIdx++);
                }
            }
        }

        edges = new ArrayList<>();
        findEdges(islandIdx - 1);

        Collections.sort(edges);

        parents = new int[islandIdx];
        for (int i = 2; i < islandIdx; i++) {
            parents[i] = i;
        }

        int totalCost = 0;
        int edgesUsed = 0;
        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                totalCost += edge.cost;
                edgesUsed++;
            }
        }

        if (edgesUsed == islandIdx - 3) { // 섬의 개수 - 1개 다리를 사용했는지 확인
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
        }
    }
}
