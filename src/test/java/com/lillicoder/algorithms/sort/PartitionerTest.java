package com.lillicoder.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PartitionerTest {

    @Test
    public void selectsIntendedPartitionAscending() {
        List<Integer> elements = new ArrayList<>();
        elements.add(5);
        elements.add(3);
        elements.add(12);
        elements.add(1);
        elements.add(0);
        elements.add(-1);
        elements.add(-10);
        elements.add(6);
        elements.add(7);
        elements.add(7);

        Integer expectedPivot = 0; // Pivot value should be 0
        int index = new Partitioner().partition(elements, Sort.Order.ASCENDING);
        Assert.assertEquals(elements.get(index), expectedPivot);
    }

    @Test
    public void selectsIntendedPartitionDescending() {
        List<Integer> elements = new ArrayList<>();
        elements.add(5);
        elements.add(3);
        elements.add(12);
        elements.add(1);
        elements.add(0);
        elements.add(-1);
        elements.add(-10);
        elements.add(6);
        elements.add(7);
        elements.add(7);

        Integer expectedPivot = 0; // Pivot value should be 0
        int index = new Partitioner().partition(elements, Sort.Order.DESCENDING);
        Assert.assertEquals(elements.get(index), expectedPivot);
    }

}
