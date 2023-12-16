package com.example.start_aston_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CustomArrayListTestClear {

    @Test
    public void testClearWhenNotEmptyThenEmpty() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add(0, "element1");
        list.add(1, "element2");
        list.add(2, "element3");

        list.clear();

        Assertions.assertEquals(0, list.size(), "Размер списка должен быть равен 0 после очистки.");
        Assertions.assertTrue(list.isEmpty(), "Список должен быть пустым после очистки.");
    }

    @Test
    public void testClearWhenEmptyThenEmpty() {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.clear();

        Assertions.assertEquals(0, list.size(), "Размер списка должен быть равен 0 после очистки.");
        Assertions.assertTrue(list.isEmpty(), "Список должен быть пустым после очистки.");
    }
}