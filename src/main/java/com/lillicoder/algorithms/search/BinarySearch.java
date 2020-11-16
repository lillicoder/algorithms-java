package com.lillicoder.algorithms.search;

import java.util.List;

/**
 * Implementation of a binary search on a given list. The given list must be sorted, otherwise
 * results are undefined. If there are multiple elements that match the given element to find, there is
 * no guarantee as to which of those elements will be found.
 *
 * <h4>Complexity</h4>
 * <ul>
 *     <li>Best case time: O(1)</li>
 *     <li>Average case time: O(log(n))</li>
 *     <li>Worst case time: O(log(n))</li>
 *     <li>Worst case space: O(1)</li>
 * </ul>
 */
class BinarySearch implements Search {

    @Override
    public <T> int search(List<? extends Comparable<? super T>> list, T toFind) {
        int position = -1;

        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            /*
              Normally a basic midpoint calculation is (low + high) / 2. However, very large integers will
              overflow past the maximum integer value and break. To avoid this, we do a unsigned right shift
              by 1 bit to safely handle very large integer.

              Alternatively you can do: low + ((high - low) / 2).
              See http://googleresearch.blogspot.com/2006/06/extra-extra-read-all-about-it-nearly.html
             */
            int middle = (low + high) >>> 1;
            Comparable<? super T> middleElement = list.get(middle);

            int comparison = middleElement.compareTo(toFind);
            if (comparison == 0) {
                // Match found, assign position and stop iteration
                position = middle;
                break;
            } else if (comparison < 0) {
                // Element to find is bigger than middle position,
                // check upper half of list
                low += middle + 1;
            } else {
                // Element to find is smaller than middle position,
                // check lower half of list
                high = middle - 1;
            }
        }

        return position;
    }

}
