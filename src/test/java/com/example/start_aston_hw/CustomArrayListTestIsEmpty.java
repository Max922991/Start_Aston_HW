package com.example.start_aston_hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomArrayListTestIsEmpty {

    private CustomArrayList<Object> customArrayList;

    @BeforeEach
    void setUp() {
        customArrayList = new CustomArrayList<>();
    }

    @Test
    void testIsEmptyWhenListIsEmptyThenReturnTrue() {
        boolean result = customArrayList.isEmpty();

        assertTrue(result, "Метод isEmpty должен возвращать значение true, когда список пуст");
    }

    @Test
    void testIsEmptyWhenListIsNotEmptyThenReturnFalse() {
        customArrayList.add(0, new Object());

        boolean result = customArrayList.isEmpty();

        assertFalse(result, "Метод isEmpty должен возвращать значение false, если список не пуст");
    }
}