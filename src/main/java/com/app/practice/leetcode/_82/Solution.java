package com.app.practice.leetcode._82;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        //head.next.next.next.next = new ListNode(3);
        /*head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(15);
        head.next.next.next.next.next.next.next.next = new ListNode(16);*/

        traverse(head);

        deleteDuplicates(head);

        traverse(head);
    }

    private static void traverse(final ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void deleteDuplicates(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode curr = head;
        ListNode ld = null;
        while (curr != null && curr.next != null) {
            if (curr.val != curr.next.val) {
                //not same
                ld = curr;
                curr = curr.next;
            } else if (curr.val == curr.next.val) {
                //same
                ListNode mark = curr.next;
                while (mark != null && mark.val == curr.val) {
                    mark = mark.next;
                }

                if (ld == null) {
                    ld = mark;
                    head = mark;
                } else {
                    ld.next = mark;
                }
                curr = mark;
            }
        }

        // return head;
    }
}
