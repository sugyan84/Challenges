package com.app.datastructure.ds1.segmenttree;

import java.util.Arrays;


/**
 * For update & range queries in O(log n) time complexity.
 */
public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int[] tree = new int[arr.length * 2];

        buildTree(arr, tree, 0, arr.length - 1, 1);

        Arrays.stream(tree).forEach(System.out::println);
    }

    public static void buildTree(int[] arr, int[] tree, int startIndex, int endIndex, int treeNodeIndex) {

        if (startIndex == endIndex) {
            tree[treeNodeIndex] = arr[startIndex];
            return;
        }
        int mid = (startIndex + endIndex) / 2;

        buildTree(arr, tree, startIndex, mid, treeNodeIndex * 2);
        buildTree(arr, tree, mid + 1, endIndex, (treeNodeIndex * 2) + 1);

        tree[treeNodeIndex] = tree[treeNodeIndex * 2] + tree[(treeNodeIndex * 2) + 1];
    }
}
