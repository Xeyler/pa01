package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySearch;

/**
 * @author Brigham Campbell
 */
public class RecursiveLinearSearch implements ArraySearch {

    /**
     * Recursive linear search implementation.
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

        return recLinearSearch(array, item, 0);
    }

    private <E extends Comparable> int recLinearSearch(E[] array, E item, int index) {
        if(index >= array.length) {
            return -1;
        } else if(array[index].compareTo(item) == 0) {
            return index;
        }
        return recLinearSearch(array, item, index + 1);
    }
}
