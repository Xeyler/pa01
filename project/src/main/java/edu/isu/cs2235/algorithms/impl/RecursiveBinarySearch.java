package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySearch;

/**
 * @author Brigham Campbell
 */
public class RecursiveBinarySearch implements ArraySearch {

    /**
     * Generic array search method.
     *
     * @param array Array to be search for the provided item
     * @param item  Item to be found
     * @return The index of the provided item in the array. Returns -1 if any of
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

        return recBinarySearch(array, item, 0, array.length - 1);
    }

    public <E extends Comparable> int recBinarySearch(E[] array, E item, int low, int high) {
        int index = (low + high) / 2;
        if(low > high)
            return -1;

        if(item.compareTo(array[index]) == 0)
            return index;

        if(item.compareTo(array[index]) < 0) {
            return recBinarySearch(array, item, low, index - 1);
        } else {
            return recBinarySearch(array, item, index + 1, high);
        }
    }
}
