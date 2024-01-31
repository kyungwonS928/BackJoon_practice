#include<iostream>
#include<string>
#include<sstream>
using namespace std;


int main() {
    int N;
    cin >> N;
    string direction;
    int x =1, y = 1;
    
    cin.ignore();
    getline(cin, direction);
    for(int i =0; i<direction.length(); i++) {
        char now = direction[i];

        if(direction == "R") {
            if(x < N) {
                x++;
            }
        } else if(direction == "L") {
            if(x>1) {
                x--;
            }
            
        } else if(direction == "U") {
            if(y>1) {
                y--;
            }
            
        } else {
            if(y<N) {
                y++;
            }

        } 
        
    }
    cout << y << " " << x;

    return 0;
}