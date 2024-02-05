#include<iostream>
#include<vector>
#include<deque>
using namespace std;

// {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

int* selection() {
    int sort[10] = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

    for (int i = 0; i < sizeof(sort) / sizeof(int); i++) {
        int min_index = i;
        for (int j = 0; j < sizeof(sort) / sizeof(int); i++) {
            if (sort[min_index] > sort[min_index]) min_index = j;
        }
        swap(sort[i], sort[min_index]);
    }

    return sort;
}

int* insert() {
    int sort[10] = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

    for (int i = 1; i < sizeof(sort) / sizeof(int); i++) {
        for (int j = i; j > 0; j--) {
            if (sort[j] < sort[j - 1]) {
                swap(sort[j], sort[j - 1]);
            }
            else { break; }
        }
    }

    return sort;
}

int sort[10] = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

void quick(int i, int j) {
    if (i >= j) { return; }

    int mid = sort[(i + j) / 2];

    int left = i;
    int right = j;

    while (left <= right) {
        while (sort[left] < mid) left++;
        while (sort[right] > mid) right--;
        if (left <= right) {
            swap(sort[left], sort[right]);
            left++; right--;
        }

    }

    quick(i, right);
    quick(left, j);


}

void counting() {
    //arr.size() + 1
    int cnt[10] ={0,};

    //arr.size() 만큼 돌기
    for(int i = 0; i<10; i++) {
        cnt[sort[i]]++;
    }

    //cnt.size() 만큼 돌기
    for(int i = 0; i<10; i++) {
        for(int j = 0; j<cnt[i]; j++) {
            cout << i << " ";
        }
    }

}



int main() {



    return 0;
}
