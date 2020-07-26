package com.app.geeks.arrays;

public class TrieDemo {

    public static void main(String[] args) {
        String[] strArr = { "cat", "cater", "art", "toon", "moon", "not", "eat", "ton" };
        
        TrieDS trie = new TrieDS();
        for (int i = 0; i < strArr.length; i++) {
            trie.addString(strArr[i]);
        }

        System.out.println(trie);
    }
}
