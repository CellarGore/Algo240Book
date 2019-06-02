package com.salar.algo240book.sorting;

public class ShellSort extends SortTemplate {
    @Override
    public void sort(Comparable[] arr) {
        int N = arr.length;

        // The h calculation and how is is being used is pretty ugly in the book
        // Maybe there should be a static variable but then where we stop
        // for the final value of h depends on N. Sounds like a helper
        int h = getH(N);
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                // insert a[i] among a[i-h], a[i-2*h], a[i-3*h]...
                for (int j = i; j >=h && isLess(arr[j], arr[j - h]); j -= h)
                    exchange(arr, j, j - h);
            }
            h /= 3;
        }
    }

    // Here is the helper
    private int getH(int N) {
        int h = 1;
        while (h < N/3) h = (3 * h) + 1;
        return h;
    }
}
