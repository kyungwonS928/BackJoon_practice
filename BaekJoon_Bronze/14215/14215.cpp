#include<iostream>
#include<algorithm>
using namespace std;

int main() {
    int x, y, z;
    
    int max = 0;
    int sum = 0;
    cin >> x >> y >> z;

    max = std::max({x, y, z});
    sum = x + y + z - max;


    if(max < sum) {
        cout << x + y + z;
    } else {
        cout <<sum + (sum -1);

    }
    

    
    return 0;
}