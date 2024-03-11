#include<iostream>
#include<string>
#include<math.h>
using namespace std;

bool isPrime(int num) {

    if(num == 1) {
        return false;
    }

    for(int i = 2; i<sqrt(num); i++) {
        if(num % i == 0) {
            return false;
        }
    }

    return true;
}

bool isPalindrome(string s) {
	int size = s.size();

	for(int i = 0; i< size/2; i++) {
		if(s[i] != s[size-1-i])
			return false;
	}

	return true;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;

    while(true) {
        if(isPrime(N) && isPalindrome(to_string(N))) {
            break;
        } else {
            N++;
        }

    }

    cout << N;
    
    return 0;

}