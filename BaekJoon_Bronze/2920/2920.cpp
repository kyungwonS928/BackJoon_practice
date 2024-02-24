#include<iostream>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int arr[8];
    for(int i = 0; i<8; i++) {
        cin >> arr[i];
    }

    int asc[8] = {1, 2, 3, 4, 5, 6, 7, 8};
    int desc[8] = {8, 7, 6, 5, 4, 3, 2, 1};

    int flagA = 0;
    for(int i = 0; i<8; i++) {
        if(asc[i] == arr[i]) {
            continue;
        } else {
            flagA = 1;
            break;
        }
    }
    int flagB = 0;
    for(int i = 0; i<8; i++) {
        if(desc[i] == arr[7-i]) {
            continue;
        } else {
            flagB = 1;
            break;
        }
    }

    if(flagA == 1 && flagB==0) {
        cout << "descending";
    } else if(flagB == 1 && flagA == 0) {
        cout << "ascending";
    } else if (flagB == 1 & flagA == 0) {
        cout << "mixed";
    }


    return 0;

}