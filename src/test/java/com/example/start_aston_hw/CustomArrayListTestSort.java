package com.example.start_aston_hw;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomArrayListTestSort {

    @Test
    public void testSortWhenListIsAlreadySortedInAscendingOrderThenListRemainsSorted() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        Comparator<Integer> ascendingOrder = Integer::compareTo;

        list.sort(ascendingOrder);

        assertEquals(1, list.get(0), "Первый элемент должен быть равен 1");
        assertEquals(2, list.get(1), "Второй элемент должен быть равен 2");
        assertEquals(3, list.get(2), "Третий элемент должен быть равен 3");
    }

    @Test
    public void testSortWhenListIsAlreadySortedInDescendingOrderThenListIsSortedInAscendingOrder() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(0, 3);
        list.add(1, 2);
        list.add(2, 1);
        Comparator<Integer> ascendingOrder = Integer::compareTo;

        list.sort(ascendingOrder);

        assertEquals(1, list.get(0), "Первый элемент должен быть равен 1");
        assertEquals(2, list.get(1), "Второй элемент должен быть равен 2");
        assertEquals(3, list.get(2), "Третий элемент должен быть равен 3");
    }

    @Test
    public void testSortWhenListIsUnsortedThenListIsSortedInAscendingOrder() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(0, 2);
        list.add(1, 3);
        list.add(2, 1);
        Comparator<Integer> ascendingOrder = Integer::compareTo;

        list.sort(ascendingOrder);

        assertEquals(1, list.get(0), "Первый элемент должен быть равен 1");
        assertEquals(2, list.get(1), "Второй элемент должен быть равен 2");
        assertEquals(3, list.get(2), "Третий элемент должен быть равен 3");
    }
}