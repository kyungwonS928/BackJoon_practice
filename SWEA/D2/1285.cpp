#include<iostream>
using namespace std;
 
int main() {
     
    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        int N;
        cin >> N;
        int min_val = 100001;
        int arr[100001] = {0, };
        for(int i = 0; i<100001; i++){
            arr[i] = 0;
        }
        for (int i = 0; i < N; i++) {
            int d;
            cin >> d;
            arr[abs(d)]++;
 
            if (min_val > abs(d)) min_val = abs(d);
        }
 
        cout << "#" << t << " " << min_val << " " << arr[min_val]<< '\n';
    }
     
    return 0;
}
