package com.app.codesignal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;


public class Demo3 {

    public static int[] traverseTree(Tree<Integer> t) {
        List<Integer> list = new ArrayList<>();
        Queue<Tree> queue = new LinkedList<>();

        if (t != null) {
            queue.offer(t);

            while (!queue.isEmpty()) {
                Tree<Integer> poll = queue.poll();
                if (poll != null) {
                    list.add(poll.value);

                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
            }
        }
        return list.stream().filter(Objects::nonNull)
                .mapToInt(Integer::intValue).toArray();
    }
}

class Tree<T> {
    T value;
    Tree<T> left;
    Tree<T> right;

    Tree(T x) {
        value = x;
    }
}