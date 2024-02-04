#include<iostream>
#include<vector>
using namespace std;

bool visited[9];

bool dfs(vector<vector<int>> arr, int x, bool* visited) {
    visited[x] = true;
    cout << x << endl;

    for(int i : arr[x]) {
        if(!visited[i]) dfs(arr, i, visited);
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


    dfs(arr, 1, visited);




}