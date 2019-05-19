package com.salar.algo240book.sorting;

public class InsertionSort extends SortTemplate {
    @Override
    public void sort(Comparable[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            // Insert arr[i] among a[i - 1], a[i - 2], a[i - 3]...
            for (int j = i; j > 0 && isLess(arr[j], arr[j - 1]); j--) {
                exchange(arr, j, j - 1);
            }
        }
    }
}
