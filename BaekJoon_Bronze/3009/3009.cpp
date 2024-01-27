#include<iostream>
using namespace std;

int main() {
    int rect1[3] = {0};
    int rect2[3] = {0};
    int result1 = 0, result2  =0;

    for(int i = 0; i<3; i++) {
        cin >> rect1[i] >> rect2[i];
    }
    
    if(rect1[0] == rect1[1]) result1 = rect1[2];
    else if(rect1[0] == rect1[2]) result1 = rect1[1];
    else result1 = rect1[0];

    if(rect2[0] == rect2[1]) result2 = rect2[2];
    else if(rect2[0] == rect2[2]) result2 = rect2[1];
    else result2 = rect2[0];


    cout << result1 << " " << result2;
    
}

// #include <bits/stdc++.h>
// using namespace std;

// int main(void){
//     int x = 0, y = 0;
//     for(int i=0; i<3; i++){
//         int a, b; 
//         cin >> a >> b;
//         x^=a; y^=b;
//     }
//     cout << x << " " << y;
// }