package com.example.start_aston_hw;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTestAdd {

    @Test
    void testAddWhenListIsEmptyThenElementAdded() {
        CustomArrayList<String> list = new CustomArrayList<>();
        String elementToAdd = "Элемент";

        list.add(0, elementToAdd);
        String result = list.get(0);

        assertEquals(elementToAdd, result, "Элемент должен быть добавлен с индексом 0, когда список пуст.");
    }

    @Test
    void testAddWhenListIsNotEmptyThenElementsAdded() {
        CustomArrayList<String> list = new CustomArrayList<>();
        String firstElement = "First";
        String secondElement = "Second";

        list.add(0, firstElement);
        list.add(1, secondElement);
        String firstResult = list.get(0);
        String secondResult = list.get(1);

        assertEquals(firstElement, firstResult, "Первый элемент должен быть добавлен с индексом 0.");
        assertEquals(secondElement, secondResult, "Второй элемент должен быть добавлен с индексом 1.");
    }

    @Test
    void testAddWhenIndexOutOfBoundsThenExceptionThrown() {
        CustomArrayList<String> list = new CustomArrayList<>();
        String elementToAdd = "Element";

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, elementToAdd),
                "Добавление элемента с индексом -1 должно вызвать исключение IndexOutOfBoundsException.");

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, elementToAdd),
                "Добавление элемента с индексом 1, когда список пуст, должно вызывать исключение IndexOutOfBoundsException.");
    }
}