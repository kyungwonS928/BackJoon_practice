#include <iostream>
using namespace std;

int* arr;
int* result;
void merge(int left, int mid, int right) {
    int i = left;
    int j = mid + 1;
    int k = left;
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            result[k++] = arr[i++];
        }
        else {
            result[k++] = arr[j++];
        }
    }
    if (i > mid) {
        while (k <= right) {
            result[k++] = arr[j++];
        }
    }
    else {
        while (k <= right) {
            result[k++] = arr[i++];
        }
    }

    for (int i = left; i <= right; i++) {
        arr[i] = result[i];
    }
}

void merge_sort(int left, int right) {
    int mid;
    if (left < right) {
        mid = (left + right) / 2;
        merge_sort(left, mid);
        merge_sort(mid + 1, right);
        merge(left, mid, right);
    }
}

int main() {
    int n;
    cin >> n;

    arr = new int[n];
    result = new int[n];
    
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    merge_sort(0, n - 1);
    for (int i = 0; i < n; i++) {
        cout << result[i] << '\n';
    }

    delete[] arr;
    delete[] result;

    return 0;
}