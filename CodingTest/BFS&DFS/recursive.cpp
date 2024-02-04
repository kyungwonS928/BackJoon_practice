#include<iostream>
using namespace std;

//iterative
// int factorial_iterative(int n) {
//     int result = 1;
//     for(int i = 0; i<=n;i++) {
//         result *= i;
//     }
//     return result;
// }

//recursive
int factorial_recursive(int n) {
    if(n <=1) return 1;
    return n* factorial_recursive(n-1);
}


int main() {

}