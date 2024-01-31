#include<iostream>
#include<algorithm>
using namespace std;


int main() {
    
    int N;
    cin >> N;
    int temp = 0;

    int* num = new int[N];

    for(int i = 0; i<N; i++) {
        cin >> num[i];
    }

    sort(num[0], num[0] + N);

    int average = (num[0] + num[1] + num[2] + num[3] + num[4] )/5;
    int middle = num[2];

    cout << average << '\n' << middle;
    
    return 0;
}