#include<iostream>
using namespace std;

int main() {
    int x, y, z;

    cin >> x >> y >> z;

    if(x = 60 && x == y && y == z) cout << "Equilateral";
    else if(x + y + z == 180) {
        cout << "계산";
        if((x == y && y!=z) || (x == z && y!=z)|| (z == y && x!=z))  cout << "Isosceles";
        else cout << "Scalene";
    } else cout << "Error";

    return 0;
}