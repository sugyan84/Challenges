package com.app.practice.leetcode._82;

public class ListNode {

    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(final int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(final ListNode next) {
        this.next = next;
    }
}
