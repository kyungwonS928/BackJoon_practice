#include<iostream>
using namespace std;



int main() {
    int a, b, c, d ,e, f;
    cin >> a >> b >> c >> d >> e >> f;

    int x, y;

    // for(x = -999; x<= 999; x++) {
    //     for(y = -999; y <= 999; y++) {
    //         if((a*x) + (b*y) == c && (d*x) + (e*y) ==f) {
    //             cout << x <<" "<<y;
    //         }
    //     }
    // }

    x = (c * e) - (b*f) / (a*e) - (b*d);
    y = (c * d) - (a*f) / (b*d) - (a*e);

    cout << x << " " << y;
}