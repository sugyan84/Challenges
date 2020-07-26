package com.app.geeks.arrays;

import java.util.HashMap;
import java.util.Map;


public class TrieDS {

    private Node root;

    static class Node {
        char val;
        Map<Character, Node> children = new HashMap<>();

        Node(final char val) {
            this.val = val;
        }

        char getVal() {
            return val;
        }

        void setVal(final char val) {
            this.val = val;
        }

        Map<Character, Node> getChildren() {
            return children;
        }

        void setChildren(final Map<Character, Node> children) {
            this.children = children;
        }
    }

    public TrieDS() {
        this.root = new Node(' ');
    }

    public void addString(String str) {
        Node currNode = this.root;
        boolean isAdded = false;
        char[] chars = str.toCharArray();
        int i = 0;

        while (i < chars.length) {
            if (currNode.children.containsKey(chars[i])) {
                currNode = currNode.getChildren().get(chars[i]);
            } else {
                Node newNode = new Node(chars[i]);
                currNode.getChildren().put(chars[i], newNode);
            }
            i++;
        }
    }

}

