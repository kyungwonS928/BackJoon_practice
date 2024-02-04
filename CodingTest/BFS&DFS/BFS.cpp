#include<iostream>
#include<vector>
#include<deque>
using namespace std;

bool visited[9];

void bfs(vector<vector<int>> arr, int start, bool* visited) {
    
    deque<int> queue;

    //현재 노드를 방문 처리하고 큐에 추가
    visited[start] = true;
    queue.push_back(start);
    
    //큐가 빌때까지 반복
    while (!queue.empty()) {
        //큐에서 하나의 원소를 뽑음
        int v = queue.front();
        queue.pop_front();
        cout << v << endl;

        //인접한 노드를 방문하지 않았다면 큐에 추가하고 방문 처리
        for(int i : arr[v]) {
            if(!visited[i]) {
                queue.push_back(i);
                visited[i] = true;
            }
        }
    }
}

int main() {
    vector<vector<int>> arr = {
        {},
        {2, 3, 8},
        {1, 7},
        {1, 4, 5},
        {3, 5},
        {3, 4},
        {7},
        {2, 6, 8},
        {1, 7}  
    };

    bfs(arr, 1, visited);

    return 0;
}
