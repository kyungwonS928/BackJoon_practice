#include<iostream>
using namespace std;

int main() {
    int N = 0;    
    int ax, ay;
    int xmax =0, ymax = 0;
    int xmin =0, ymin = 0;

    cin >> N;
    if(N == 1) {
        cout << 0;
        return 0;
    }
    for(int i = 0; i<N; i++) {
        cin >> ax >> ay;

        if(xmax < ax) xmax = ax;
        else if(xmin > ax) xmin = ax;

        if(ymax < ay) ymax = ay;
        else if(ymin > ay) ymin = ay;
    }

    cout << (xmax-xmin) * (ymax-ymin);

    return 0;
}