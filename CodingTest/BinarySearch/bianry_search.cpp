#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

vector<int> arr;

int recursive(int target, int start, int end) {
    if(start>end) return;
    int mid = (start+end)/2;
    if(arr[mid] == target) return mid;
    else if(arr[mid] > target) {
        return recursive(target, start, mid-1);
    }
    else return recursive(target, mid+1, end);


}

int repeat(int target, int start, int end) {
    while(start <= end) {
        int mid = (start+end) /2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] > target) end=mid-1;
        else start = mid+1;
    }
    return;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    
    
    return 0;

} 