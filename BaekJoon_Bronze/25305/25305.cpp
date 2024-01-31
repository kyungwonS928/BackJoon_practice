#include<iostream>
#include<algorithm>
using namespace std;

int main() {
    int N, k;
    cin >> N >>k;
    int* student = new int[N];

    for(int i = 0; i<N;i++) {
        cin >> student[i];
    }

    sort(student, student + N);

    cout << student[N-k];

    delete[] student;
    return 0;
}