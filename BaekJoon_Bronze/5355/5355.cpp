#include<iostream>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int  T;
    cin >> T;

    for(int i = 0 ; i<T; i++) {
        double n = 0.0;
        cin >> n;

        while(1) {
            char ch;
            cin >> ch;
            if(ch == '\n') break;
            else if (ch == '@') n*=3;
            else if (ch == '%') n+=5;
            else n-=7;

            cout << "di";
        }

        cout<<fixed;
        cout.precision(2);
        cout<<n<<"\n";
    }
    return 0;

}