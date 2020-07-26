package com.app.codesignal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;


public class Demo4 {

    public static int[] traverseTree(Tree<Integer> t) {
        Comparator<Tree<Integer>> comparator = (i1, i2) -> i2.value.compareTo(i1.value);

        List<Integer> list = new ArrayList<>();
        Queue<Tree<Integer>> queue = new PriorityQueue<Tree<Integer>>(comparator);
        boolean toBeAdded = true;

        if (t != null) {
            queue.offer(t);
            queue.offer(null);
            while (!queue.isEmpty()) {
                Tree<Integer> poll = queue.poll();
                if (poll != null) {
                    if (toBeAdded) {
                        list.add(poll.value);
                        toBeAdded = false;
                    }

                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                } else {
                    toBeAdded = true;
                }
            }
        }
        return list.stream().filter(Objects::nonNull)
                .mapToInt(Integer::intValue).toArray();
    }
}