#include<iostream>
#include<algorithm>
using namespace std;

int main() {
    int x, y, z;
    
    while(1) {
        
    int max = 0;
    int sum = 0;
        cin >> x >> y >> z;
        if (x == 0 && y == 0 && z == 0) return 0;

        max = std::max({x, y, z});
        sum = x + y + z - max;

        
        if(max < sum) {
            if(x == y && y == z) {
            cout << "Equilateral" << endl;
            }
            else if((x == y) || (x == z)|| (z == y))  cout << "Isosceles" << endl;
            else cout << "Scalene" << endl;
        } else cout << "Invalid" << endl;
    

    }
    
    return 0;
}