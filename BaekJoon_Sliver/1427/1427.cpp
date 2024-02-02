#include<iostream>
#include<string>
#include <algorithm>
using namespace std;



int main() {

    string numstr;
    cin >> numstr;
    

    sort(numstr.begin(), numstr.end(), greater<char>());

    cout << numstr << endl;
    

    return 0;
}