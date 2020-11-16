package com.lillicoder.algorithms.search;

import java.util.List;

interface Search {

    /**
     * Searches the given {@link List} for the given element.
     * @param list List to search.
     * @param toFind Element to find.
     * @param <T> Type of element.
     * @return Position of element or {@code -1} if no such element could be found.
     */
    <T> int search(List<? extends Comparable<? super T>> list, T toFind);

}
