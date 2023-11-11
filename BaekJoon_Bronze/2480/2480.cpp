#include <iostream>
using namespace std;

int main() { 
    int A, B, C;
    int P;
    cin >> A >> B >> C;
    if(A == B && B == C) {
        P = 10000 + A*1000;
    } else if (A == B || B == C || A == C) {
        if(A == B || A==C) P = 1000+A*100;
        else P = 1000+B*100;
    } else {
        int max;
        if(A>B) {
            if(C>A) max = C;
            else max = A;
        }
        else {
            if(C>B) max = C;
            else max= B;
        }
        P = max*100;
    }

    cout << P;
}