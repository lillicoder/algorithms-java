package com.lillicoder.algorithms.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Merger {

    /**
     * Merges the elements of the given lists into a single list with the given {@link Sort.Order}. Each given
     * list is assumed to already be sorted in the given order.
     * @param left List to merge.
     * @param right List to merge.
     * @param <T> Type of elements to merge. The type must support the {@link Comparable} interface.
     * @return Sorted list.
     */
    <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right, Sort.Order order) {
        List<T> merged = new ArrayList<>(left.size() + right.size());

        Comparator<T> comparator =
                order == Sort.Order.ASCENDING ? new Sort.AscendingComparator<>() : new Sort.DescendingComparator<>();

        // To do this, simply walk over the total number of elements in both lists and advance
        // a index tracking value for each list so that we add elements in the right comparison order
        int leftPosition = 0;
        int rightPosition = 0;
        for (int index = 0; index < left.size() + right.size(); index++) {
            if (leftPosition < left.size() && rightPosition < right.size()) {
                // Both positions in bounds, do comparison
                T leftElement = left.get(leftPosition);
                T rightElement = right.get(rightPosition);

                int comparison = comparator.compare(leftElement, rightElement);
                if (comparison < 1) {
                    // Left precedes or is equal to right, take left
                    merged.add(leftElement);
                    leftPosition++;
                } else {
                    // Right precedes left, take right
                    merged.add(rightElement);
                    rightPosition++;
                }
            } else if (leftPosition < left.size()) {
                // Left in bounds and right is not, take left
                merged.add(left.get(leftPosition));
                leftPosition++;
            } else if (rightPosition < right.size()) {
                // Right in bounds and left is not, take right
                merged.add(right.get(rightPosition));
                rightPosition++;
            } else {
                System.out.println("Something is going wrong, nobody is in bounds!");
            }
        }

        return merged;
    }

}
