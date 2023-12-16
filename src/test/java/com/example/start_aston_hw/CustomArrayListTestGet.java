package com.example.start_aston_hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTestGet {

    private CustomArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new CustomArrayList<>();
        list.add(0, "First");
        list.add(1, "Second");
        list.add(2, "Third");
    }

    @Test
    void testGetWhenIndexIsValidThenReturnElement() {
        String element = list.get(1);

        assertEquals("Second", element,
                "Метод get должен возвращать правильный элемент для допустимого индекса.");
    }

    @Test
    void testGetWhenIndexIsNegativeThenThrowException() {
        int invalidIndex = -1;

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(invalidIndex),
                "Метод get должен вызывать исключение IndexOutOfBoundsException для отрицательного индекса.");
    }

    @Test
    void testGetWhenIndexIsGreaterThanSizeThenThrowException() {
        int invalidIndex = list.size() + 1;

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(invalidIndex),
                "Метод get должен вызывать исключение IndexOutOfBoundsException для индекса, превышающего размер.");
    }
}