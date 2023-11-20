#include<iostream>
#include<string>
using namespace std;

int main() {
    
    string input;
    char res;
    int count[26] = {0, };
    int max = 0;

    cin >> input;

    for(int i = 0; i<input.length(); i++) {
        if(input[i] > 'Z') count[input[i] - 'a']++;
        else count[input[i]-'A']++;
    }

    for(int i = 0; i<26; i++) {
        if(count[i] > max) {
            max = count[i];
            res = (char) i+'A';
        } else if(count[i] == max) res='?';
    }

    cout << res;
    
    return 0;

}