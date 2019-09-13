package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySearch;

/**
 * @author Brigham Campbell
 */
public class LinearSearch implements ArraySearch {

    /**
     * Linear search implementation.
     *
     * @param array Array to be searched for the provided item
     * @param item  Item to be found
     * @return The index of the specified item in the array. Returns -1 if any of
     * the following conditions are met:
     * <ul>
     * <li>The provided array is null</li>
     * <li>The provided array is empty</li>
     * <li>The provided item is null</li>
     * <li>The provided array does not contain the item</li>
     * </ul>
     */
    @Override
    public <E extends Comparable> int search(E[] array, E item) {
        if(array == null || item == null || array.length == 0)
            return -1;

        for(int i = 0; i < array.length - 1; i += 1) {
            if(array[i].compareTo(item) == 0)
                return i;
        }

        return -1;
    }
}
