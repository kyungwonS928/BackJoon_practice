#include<iostream>
#include<string>
using namespace std;


int main() {

    string S;

    cin >> S;
    int *array = new int[26];

    for(int i =0; i<26; i++){
        array[i] = -1;
    }

    for(int i = 0; i<S.length(); i++){
        if(array[S[i]-'a'] == -1) {
            array[S[i] -'a'] = i;
        }
    }

    for(int i = 0; i<26;i++) {
        cout << array[i] <<" ";
    }

}