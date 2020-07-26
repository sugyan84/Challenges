package com.app.leetcode.monthly.june;

public class Day26 {

    static int globalSum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.right = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(0);

        System.out.println(" = " + sumNumbers(root));
        
    }
    
    public static int sumNumbers(TreeNode root) {
        if (root != null) {
            sumPath(root, 0);
        }
        return globalSum;
    }

    public static void sumPath(TreeNode currNode, int currSum) {
        int value = 0;

        if (currNode != null) {
            value = (currSum * 10) + currNode.val;
        }

        if (currNode != null && currNode.left == null && currNode.right == null) {
            //leaf Node.
            globalSum += value;
            return;
        } else {
            sumPath(currNode.left, value);
            sumPath(currNode.right, value);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}