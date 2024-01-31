#include<iostream>
#include<string>
using namespace std;


int main() {
    int N;
    cin >> N;

    int result = -1;
    
    if(N%5 == 0) {
        cout << N/5;
        
        return 0;
    }
    //i는 몫
    for(int i = N/5; i>=0; i--) {
        
        int temp = N;
        temp = N - i*5;
        
        if(temp % 3 == 0) {
            
            result = i + (temp/3);
            
            break;
        } else {
            continue;
        }
        
    }
    

    cout << result;

    return 0;
}