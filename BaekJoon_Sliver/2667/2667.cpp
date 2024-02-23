#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cstring> // For memset
using namespace std;


bool dfs(vector<string>& graph, int x, int y, int& apartment) {

    if(x < 0 || x >= graph.size() || y < 0 || y>=graph.size() || graph[x][y] == '0') {
        return false;
    }
    
    if(graph[x][y] == '1') {
        graph[x][y] = '0';
        apartment++;
        dfs(graph, x-1, y, apartment);
        dfs(graph, x, y-1, apartment);
        dfs(graph, x+1, y, apartment);
        dfs(graph, x, y+1, apartment);
        return true;
    }
    return false;
    
}

int main() {
    int N;
    cin >> N;

    vector<string> graph;

    for(int i = 0; i< N; i++) {
        string tmp;
        cin >> tmp;
        graph.push_back(tmp);
    }


    int apartment;
    vector<int> cnt; 
    
    for(int i = 0; i<N; i++) {
        for(int j = 0; j<graph[i].size(); j++) {
            if (graph[i][j] == '1') {
                apartment = 0; 
                dfs(graph, i, j, apartment);
                cnt.push_back(apartment);
            }
            
        }
        
    }
    
    sort(cnt.begin(), cnt.end());
    cout << cnt.size() << '\n';
    for(int i = 0; i<cnt.size(); i++) {
        cout << cnt[i] << '\n';
    }
    
    return 0;
}
