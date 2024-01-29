#include <iostream>
using namespace std;

int main(void){
    int num[100];
    int N, M;
    cin >> N >> M;

    int sum =0;

    
    for(int i = 0; i<N; i++) {
        cin >> num[i];
    }

    for(int i = 0; i<N-2; i++) {
        for(int j = i+1; j<N-1; j++) {
            for (int k = j+1; k<N; k++) {
                int temp = 0;
                temp = num[i] + num[j] + num[k];

                if(M >= temp && sum < temp) sum = temp;
            }
        }
    }

    cout << sum;

    
    return 0;
}