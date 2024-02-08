#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<pair<int, string>> members;
    int N;
    cin >> N;
    vector<int> cards;

    for(int i = 0; i<N; i++) {
        int n;
        cin >> n;
        cards.push_back(n);
    }
    
    sort(cards.begin(), cards.begin()+N);


    int M;
    cin >> M;
    for(int i = 0; i<M; i++) {
        int num;
        cin >> num;
        //한줄 입력, 출력은 다른 연산과 합쳐보기
        if(binary_search(cards.begin(), cards.end(), num)) {
            cout << "1" << " ";
        } else cout << "0" << " ";

        
    }
    

    return 0;

} 