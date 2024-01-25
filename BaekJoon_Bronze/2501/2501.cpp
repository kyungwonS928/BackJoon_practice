#include<iostream>
using namespace std;


int main() {
    int N, K;
    int flag = 0;
    //초기화를 하지 않으면 해당 변수는 쓰레기값을 가지게 되기 때문에 예상치 못한 결과가 나올 수도 있음 -> 어떤 값이 들어있는지 확신할 수 없음

    cin >> N >> K;

    
    for(int i = 1; i<=N; i++) {
        if(N % i == 0) {
            flag++;
            if(flag == K) {
                cout << i;
                return 0;
            }
        }
    }

    cout << "0";

    return 0;

}