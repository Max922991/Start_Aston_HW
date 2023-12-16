package com.example.start_aston_hw;

import java.util.Comparator;

public class CustomSort<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public void CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }


    /**
     * Sort(Comparator<? super E> c): Сортирует элементы списка с использованием указанного компаратора c. Реализация метода:
     * Вызывает приватный метод quicksort с начальными параметрами 0 и size - 1, чтобы выполнить сортировку элементов списка.
     * Метод quicksort реализует алгоритм быстрой сортировки (quicksort) для сортировки элементов внутреннего массива elements.
     */
    public void sort(Comparator<? super E> c) {
        quicksort(0, size - 1, c);
    }

    /**
     * Quicksort(int low, int high, Comparator<? super E> c): Приватный метод, реализующий алгоритм быстрой сортировки (quicksort). Реализация метода:
     * Если low меньше high, выбирает опорный элемент (pivot) из массива elements с индексом high.
     * Разделяет массив elements на две части: элементы, меньшие или равные опорному элементу, и элементы, большие опорного элемента.
     * Рекурсивно вызывает quicksort для обеих частей массива.
     * В итоге, массив elements будет отсортирован в порядке, определенном компаратором c.
     */
    private void quicksort(int low, int high, Comparator<? super E> c) {
        if (low < high) {
            int pivotIndex = partition(low, high, c);
            quicksort(low, pivotIndex - 1, c);
            quicksort(pivotIndex + 1, high, c);
        }
    }

    /**
     * Partition(int low, int high, Comparator<? super E> c): Приватный метод, выполняющий разделение массива на две части в алгоритме быстрой сортировки.
     * Реализация метода: Задает опорный элемент (pivot) из массива elements с индексом high.
     * Инициализирует переменную i со значением low - 1.
     * Итерируется по элементам массива elements с индексами от low до high - 1.
     * Если текущий элемент меньше или равен опорному элементу, увеличивает i на 1 и меняет местами элементы с индексами i и j.
     * Меняет местами опорный элемент и элемент с индексом i + 1.
     * Возвращает индекс опорного элемента после разделения массива.
     */
    private int partition(int low, int high, Comparator<? super E> c) {
        E pivot = (E) elements[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (c.compare((E) elements[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    /**
     * Swap(int i, int j): Приватный метод, меняющий местами элементы массива elements с индексамиi и j. Реализация метода:
     * Создает временную переменную temp и присваивает ей значение элемента elements[i].
     * Присваивает элементу elements[i] значение элемента elements[j].
     * Присваивает элементу elements[j] значение временной переменной temp.
     */
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
}