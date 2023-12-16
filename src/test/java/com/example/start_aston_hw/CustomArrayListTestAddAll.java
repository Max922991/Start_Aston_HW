package com.example.start_aston_hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CustomArrayListTestAddAll {
    private CustomArrayList<String> customArrayList;
    @BeforeEach
    void setUp() {
        customArrayList = new CustomArrayList<>();
    }

    @Test
    void testAddAllWhenCollectionIsEmptyThenReturnTrueAndNoModification() {
        Collection<String> emptyCollection = new ArrayList<>();

        boolean result = customArrayList.addAll(emptyCollection);

        assertTrue(result, "Метод addAll должен возвращать значение true, когда коллекция пуста.");
        assertTrue(customArrayList.isEmpty(), "CustomArrayList не следует изменять при добавлении пустой коллекции.");
    }

    @Test
    void testAddAllWhenCollectionIsNotEmptyThenReturnTrueAndAddElementsInCorrectOrder() {
        Collection<String> collection = Arrays.asList("Element1", "Element2", "Element3");

        boolean result = customArrayList.addAll(collection);

        assertTrue(result, "Метод addAll должен возвращать значение true при добавлении непустой коллекции.");
        assertEquals(collection.size(), customArrayList.size(), "Размер CustomArrayList должен быть увеличен на размер коллекции.");
        int index = 0;
        for (String element : collection) {
            assertEquals(element, customArrayList.get(index++), "Элементы должны быть добавлены в правильном порядке.");
        }
    }
}