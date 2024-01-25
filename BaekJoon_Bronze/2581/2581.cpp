#include<iostream>
#include<cmath>
using namespace std;


int main() {
    int M, N;
    cin >> M >> N;
    int minPrime = 0;
    int sum = 0;

    for(int i = M; i <= N; i++) {
        int temp = sqrt(i);
        int flag = 0;
        for(int j = 2; j <= temp; j++) {
            if(i % j == 0) {
                flag = 1;
                break;
            }
        }
            
        
        
        
        if(flag == 0) {
            if (sum == 0) {
                minPrime = i;
            }
            sum += i;
        }
        
    }

    if(sum != 0) {
        cout << sum << endl;
        cout << minPrime;
    } else {
        cout << "-1";
    }
    return 0;

}