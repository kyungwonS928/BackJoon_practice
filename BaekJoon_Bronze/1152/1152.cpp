#include<iostream>
#include<string>
using namespace std;


int main() {
    string S;
    int C=1;

    getline(cin, S);

    for(int i = 0; i < S.length(); i++) {
        if(S[i] == ' ') {
            C++;
        }
    }

    /// if(S[0] == ' ' || S[S.length()-1] == ' ') C--;
    /// 그냥 or 연산자로 안되는 이유 -> 두가지 모두 true 경우를 걸러내지 못함
    if(S[0] == ' ') C--;
    if(S[S.length() -1] ==' ') C--;
    cout << C;
}