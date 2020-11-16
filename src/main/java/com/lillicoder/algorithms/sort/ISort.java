package com.lillicoder.algorithms.sort;

import java.util.List;

public interface ISort {

    /**
     * Performs a sort on the given list for the given {@link Sort.Order}.
     * @param list List to sort.
     * @param order Order for the sort.
     * @param <T> Type of element to sort. The type must support the {@link Comparable} interface.
     * @return Sorted list.
     * @throws NullPointerException Thrown if the given list contains a {@code null} element.
     */
    <T extends Comparable<? super T>> List<T> sort(List<T> list, Sort.Order order);

}
