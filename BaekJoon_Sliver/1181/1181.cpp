#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

bool compare(string i, string j) {
    if(i.length() == j.length()) {
        for(int n=0; n<i.length(); n++) {
            if(i[n] == j[n]) {
                continue;
            }
            else {return int(i[n]) < int(j[n]);}
        }
    }
    
    return i.length() < j.length();
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<string> words;
    int N;
    cin >> N;

    for(int i = 0; i<N; i++) {
        string word;
        cin >> word;
        words.push_back(word);
    }
    
    sort(words.begin(), words.begin() + N, compare);

    auto it = unique(words.begin(), words.begin() + N);
    words.resize(distance(words.begin(), it));

    for(int i = 0; i<words.size(); i++) {
        cout << words[i] << '\n';
    } 
    return 0;

} 