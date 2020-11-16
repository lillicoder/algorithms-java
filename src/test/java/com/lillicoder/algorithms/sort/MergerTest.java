package com.lillicoder.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MergerTest {

    @Test
    public void mergesSortedListsAscending() {
        List<Integer> left = new ArrayList<>();
        left.add(-9);
        left.add(3);
        left.add(10);
        left.add(23);
        left.add(499);

        List<Integer> right = new ArrayList<>();
        right.add(-11);
        right.add(0);
        right.add(29);
        right.add(101);
        right.add(600);

        List<Integer> merged = new Merger().merge(left, right, Sort.Order.ASCENDING);
        Assert.assertTrue(new Sort() {
            @Override
            public <T extends Comparable<? super T>> List<T> sort(List<T> list, Order order) {
                // This method is not under test here
                return null;
            }
        }.isSorted(merged, Sort.Order.ASCENDING));
    }

    @Test
    public void mergesSortedListsDescending() {
        List<Integer> left = new ArrayList<>();
        left.add(499);
        left.add(23);
        left.add(10);
        left.add(3);
        left.add(-9);

        List<Integer> right = new ArrayList<>();
        right.add(600);
        right.add(101);
        right.add(29);
        right.add(0);
        right.add(-11);

        List<Integer> merged = new Merger().merge(left, right, Sort.Order.DESCENDING);
        Assert.assertTrue(new Sort() {
            @Override
            public <T extends Comparable<? super T>> List<T> sort(List<T> list, Order order) {
                // This method is not under test here
                return null;
            }
        }.isSorted(merged, Sort.Order.DESCENDING));
    }

    @Test
    public void doesNotMergeUnsortedListsAscending() {
        List<Integer> left = new ArrayList<>();
        left.add(499);
        left.add(23);
        left.add(10);
        left.add(3);
        left.add(-9);

        List<Integer> right = new ArrayList<>();
        right.add(600);
        right.add(101);
        right.add(29);
        right.add(0);
        right.add(-11);

        List<Integer> merged = new Merger().merge(left, right, Sort.Order.ASCENDING);
        Assert.assertFalse(new Sort() {
            @Override
            public <T extends Comparable<? super T>> List<T> sort(List<T> list, Order order) {
                // This method is not under test here
                return null;
            }
        }.isSorted(merged, Sort.Order.ASCENDING));
    }

    @Test
    public void doesNotMergeUnsortedListsDescending() {
        List<Integer> left = new ArrayList<>();
        left.add(-9);
        left.add(3);
        left.add(10);
        left.add(23);
        left.add(499);

        List<Integer> right = new ArrayList<>();
        right.add(-11);
        right.add(0);
        right.add(29);
        right.add(101);
        right.add(600);

        List<Integer> merged = new Merger().merge(left, right, Sort.Order.DESCENDING);
        Assert.assertFalse(new Sort() {
            @Override
            public <T extends Comparable<? super T>> List<T> sort(List<T> list, Order order) {
                // This method is not under test here
                return null;
            }
        }.isSorted(merged, Sort.Order.DESCENDING));
    }

}
