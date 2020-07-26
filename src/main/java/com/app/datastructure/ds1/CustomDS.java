package com.app.datastructure.ds1;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;


/**
 * This DS does the below operations.
 *
 * Insert an element
 * Delete an element
 * Return sum of unique elements whose frequency is less than or equal to F (given frequency).
 */
public class CustomDS {

    TreeMap<Integer, Integer> map = new TreeMap();

    public void addElement(Integer element){
        map.computeIfPresent(element, (key, val) -> val+1);
        map.computeIfAbsent(element, key -> map.put(key, 1));
    }

    public void deleteElement(Integer element){
        map.computeIfPresent(element, (key, val) -> map.put(key, val-1));
    }

    public Integer getSumWithFrequency(Integer freq){
        final AtomicReference<Integer> retVal = new AtomicReference<>(new Integer(0));

        int sum = map.entrySet().stream()
                .filter(entry -> entry.getValue() <= freq)
                .mapToInt(entry -> entry.getKey())
                .sum();

        return sum;
    }
}
