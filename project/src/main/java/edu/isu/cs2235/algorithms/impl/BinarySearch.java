package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySearch;

/**
 * @author Brigham Campbell
 */
public class BinarySearch implements ArraySearch {

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

        int high = array.length - 1;
        int low = 0;
        int index;
        while (low <= high) {
            index = (low + high) / 2;
            if(item.compareTo(array[index]) == 0) {
                return index;
            } else if(item.compareTo(array[index]) < 0) {
                high = index - 1;
            } else {
                low = index + 1;
            }
        }
        return -1;
    }
}
