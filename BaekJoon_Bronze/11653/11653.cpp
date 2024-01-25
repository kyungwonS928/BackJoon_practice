// #include<iostream>
// #include<cmath>
// using namespace std;


// int main() {
//     int N;
//     cin >> N;
//     int minPrime = 0;
//     int sum = 0;

//     if(N ==1) {
//         return 0;
//     }
    
//     int temp = N;
//     for(int i = 2; i <= N; i++) {
//         int flag = 0;
//         for(int j = 2; j <= sqrt(N); j++) {
//             if(i % j == 0) {
//                 flag = 1;
//                 cout << i;
//                 break;
//             }
//         }
        
        
//         if(flag == 0) {
//             for( int j = i; temp % j==0; temp /= j) {
//                 cout << i <<endl;
//             }
//         }
        
//     }

//     return 0;

// }

#include<iostream>
#include<cmath>
using namespace std;


int main() {
    int N;
    cin >> N;
    int minPrime = 0;
    int sum = 0;

    if(N ==1) {
        return 0;
    }
    
    int temp = N;
    for(int i = 2; i <= sqrt(N); i++) {
        
        
        for( int j = i; temp % j==0; temp /= j) {
            cout << i << endl;
        }
        
        
    }

    return 0;

}