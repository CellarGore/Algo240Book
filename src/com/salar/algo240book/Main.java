package com.salar.algo240book;

import com.salar.algo240book.chapter1.UnionFind;
import com.salar.algo240book.sorting.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // int N = 200;
        // UnionFind uf = new UnionFind(N);

        InsertionSort insertionSort = new InsertionSort();

        List<Integer> simpleList = Arrays.asList(10, 11, 89, 12, 49, 48, 56, 20, 9);

        Integer[] simpleArray = new Integer[simpleList.size()];

        for (int i = 0; i < simpleList.size(); i++) {
            simpleArray[i] = simpleList.get(i);
        }

        insertionSort.sort(simpleArray);

        for (Integer j : simpleArray) System.out.println(j);
    }
}
