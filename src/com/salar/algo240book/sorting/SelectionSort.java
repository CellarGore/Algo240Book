package com.salar.algo240book.sorting;

public class SelectionSort extends SortTemplate {
    @Override
    public void sort(Comparable[] arr) {
        // Sort arr to increasing order
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            // Exchange a[i] with the smallest entry in arr[i+1...N)
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (isLess(arr[j], arr[min])) min = j;
            }
            exchange(arr, i, min);
        }
    }
}
