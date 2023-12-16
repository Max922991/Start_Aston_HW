package com.example.start_aston_hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomArrayListTestRemoveIndex {

    private CustomArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new CustomArrayList<>();
    }

    @Test
    void testRemoveWhenIndexWithinRangeThenRemoveElement() {
        list.add(0, "First");
        list.add(1, "Second");
        list.add(2, "Third");
        int initialSize = list.size();

        String removedElement = list.remove(1);

        assertEquals("Second", removedElement, "Удаленный элемент должен быть Second.");
        assertEquals(initialSize - 1, list.size(), "Размер списка должен быть уменьшен на 1.");
    }

    @Test
    void testRemoveWhenIndexOutOfRangeThenThrowException() {
        list.add(0, "First");
        int invalidIndex = list.size();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(invalidIndex),
                "Удаление с индексом вне диапазона должно вызывать исключение IndexOutOfBoundsException.");
    }

    @Test
    void testRemoveWhenListIsEmptyThenThrowException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0),
                "Удаление из пустого списка должно вызвать исключение IndexOutOfBoundsException.");
    }
}