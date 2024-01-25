#include<iostream>
#include<string>
using namespace std;


int main() {
    int N;
    cin >> N;
    int count = 0;

    for(int i = 0; i<N; i++) {
        int num = 0;
        int flag = 0;
        cin >> num;

        for(int j =1;j < num/2; j++) {
            
            if(num > 1 && num%j ==0 && j != 1 ) {
                flag = 1;
                break;
            }
        }

        if(flag == 0) {
            count++;
        }
    }

    cout << count;


    return 0;

}