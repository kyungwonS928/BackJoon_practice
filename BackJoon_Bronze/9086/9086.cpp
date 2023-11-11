#include<iostream>
#include<string>
using namespace std;


int main() {
    int T;
    cin >> T;
    string *input_string = new string[T];

    for(int i =0; i<T; i++) {
        cin >> input_string[i];
    }

    for(int i = 0; i<T; i++) {
        cout << input_string[i].front() << input_string[i].back()<<'\n';
    }

    delete[] input_string;

}