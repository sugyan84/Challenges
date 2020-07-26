package com.app.practice.leetcode._117;

import java.util.LinkedList;
import java.util.Queue;


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Node currElem = root;
        queue.offer(currElem);

        while (!queue.isEmpty()) {
            currElem = queue.poll();

            if (currElem == null) {
                queue.offer(null);
            }

            if (currElem == null && queue.peek() == null) {
                break;
            }

            queue.offer(currElem.left);
            queue.offer(currElem.right);

            currElem.right = queue.peek();
        }

        return root;
    }
}
