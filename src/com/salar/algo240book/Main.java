package com.salar.algo240book;

import com.salar.algo240book.chapter1.UnionFind;
import com.salar.algo240book.sorting.InsertionSort;
import com.salar.algo240book.sorting.ShellSort;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // int N = 200;
        // UnionFind uf = new UnionFind(N);

        // Well this took longer to figure out than it should have
        // I need an array of Integers and this is the best way I came up with
        // Create a List object and then populate a list with the Integers one by one -_-
        // Has to be a better way of doing this

        List<Integer> simpleList = Arrays.asList(10, 11, 89, 12, 49, 48, 56, 20, 9);
        Integer[] simpleArray = new Integer[simpleList.size()];
        InsertionSort insertionSort = new InsertionSort();
        ShellSort shellSort = new ShellSort();

        for (int i = 0; i < simpleList.size(); i++) {
            simpleArray[i] = simpleList.get(i);
        }

        shellSort.sort(simpleArray);
        for (Integer j : simpleArray) System.out.println(j);
    }
}
