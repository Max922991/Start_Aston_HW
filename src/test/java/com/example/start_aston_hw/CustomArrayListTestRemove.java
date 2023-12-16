package com.example.start_aston_hw;

import com.example.start_aston_hw.CustomArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CustomArrayListTestRemove {
    private CustomArrayList<String> customArrayList;

    @BeforeEach
    public void setUp() {
        customArrayList = new CustomArrayList<>();
        customArrayList.addAll(Arrays.asList("apple", "banana", "cherry"));
    }

    @Test
    public void testRemoveExistingElement() {
        boolean result = customArrayList.remove("banana");
        Assertions.assertTrue(result);
        Assertions.assertEquals(2, customArrayList.size());
        Assertions.assertEquals("apple", customArrayList.get(0));
        Assertions.assertEquals("cherry", customArrayList.get(1));
    }

    @Test
    public void testRemoveNonExistingElement() {
        boolean result = customArrayList.remove("grape");
        Assertions.assertFalse(result);
        Assertions.assertEquals(3, customArrayList.size());
        Assertions.assertEquals("apple", customArrayList.get(0));
        Assertions.assertEquals("banana", customArrayList.get(1));
        Assertions.assertEquals("cherry", customArrayList.get(2));
    }
}