#include <iostream>
#include <vector>
#include <deque>
#include <algorithm>
#include <cstring> // For memset
using namespace std;

bool visitedbfs[1000] = {false,};
bool visiteddfs[1000] = {false,};

void bfs(vector<vector<int>>& graph, int v) {
    deque<int> queue;
    queue.push_back(v);
    visitedbfs[v] = true;

    while(!queue.empty()) {
        int temp = queue.front();
        queue.pop_front();
        cout << temp << " ";

        for(int i : graph[temp]) {
            if(!visitedbfs[i]) {
                visitedbfs[i] = true;
                queue.push_back(i);
            }
        }
    }
}

void dfs(vector<vector<int>>& graph, int v) {
    visiteddfs[v] = true;
    cout << v << " ";

    for(int i : graph[v]) {
        if(!visiteddfs[i]) {
            visiteddfs[i] = true;
            dfs(graph, i);
        }
    }
}

int main() {
    int N, M, V;
    cin >> N >> M >> V;

    vector<vector<int>> graph(N + 1);

    for(int i = 0; i < M; i++) {
        int m, n;
        cin >> m >> n;
        graph[m].push_back(n);
        graph[n].push_back(m); // Undirected graph
    }

    // Sort adjacency lists for each vertex for consistent ordering
    for(int i = 1; i <= N; i++) {
        sort(graph[i].begin(), graph[i].end());
    }

    bfs(graph, V);
    cout << '\n';

    memset(visiteddfs, false, sizeof(visiteddfs)); // Reset visited array for DFS

    dfs(graph, V);
    
    return 0;
}
