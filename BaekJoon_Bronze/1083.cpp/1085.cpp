#include<iostream>
using namespace std;

int main() {
    int x, y, w, h;
    cin >> x >> y >> w >> h;
    int horizontal =0, vertical =0;    
    int min = 0;

    if(x > (w-x)) horizontal = (w-x);
    else horizontal = x;

    if(y > (h-y)) vertical = (h-y);
    else vertical = y;

    if(horizontal > vertical) min = vertical;
    else min = horizontal;

    cout << min;
    
    return 0;
}