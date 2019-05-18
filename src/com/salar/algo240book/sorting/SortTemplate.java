package com.salar.algo240book.sorting;

abstract class SortTemplate {
    abstract void sort(Comparable[] arr);

    protected boolean isLess(Comparable first, Comparable second) {
        // I can see why IntelliJ is throwing a warning here. Because it doesn't know
        // that we will always use the same Comparable.
        // I wonder if I can just add a parameter to the class up there
        // Okay so that doesn't work

        return first.compareTo(second) < 0;
    }

    protected void exchange(Comparable[] a, int first, int second) {
        Comparable t = a[first];
        a[first] = a[second];
        a[second] = t;
    }

    protected void show(Comparable[] arr) {
        // Print the array on a single line
        for (Comparable comparable : arr) {
            System.out.println(comparable + " ");
        }
    }

    public boolean isSorted(Comparable[] arr) {
        // Test whether array entries are in order
        for (int i = 1; i < arr.length; i++) {
            if (isLess(arr[i], arr[i - 1])) return false;
        }
        return true;
    }
}
