package com.example.start_aston_hw;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * Метод add(int index, E element): Добавляет элемент element в список по указанному индексу index.
     * Если индекс выходит за пределы текущего размера списка, выбрасывается исключение IndexOutOfBoundsException.
     * Метод сначала проверяет, достаточно ли места в массиве elements, и при необходимости увеличивает его размер.
     * Затем с помощью метода System.arraycopy элементы сдвигаются вправо, чтобы освободить место для нового элемента,
     * и новый элемент добавляется на указанный индекс.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }


    /**
     * Метод addAll(Collection<? extends E> c): Добавляет все элементы из коллекции c в конец списка.
     * Метод сначала проверяет, достаточно ли места в массиве elements, и при необходимости увеличивает его размер.
     * Затем элементы из коллекции c добавляются в массив elements начиная с индекса size.
     */
    public boolean addAll(Collection<? extends E> c) {
        ensureCapacity(size + c.size());
        int index = size;
        for (E element : c) {
            elements[index++] = element;
        }
        size += c.size();
        return true;
    }

    /**
     * Метод clear(): Удаляет все элементы из списка и устанавливает размер списка в 0.
     * Для этого метод использует метод Arrays.fill, чтобы заполнить массив elements значениями null.
     */
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    /**
     * Метод get(int index): Возвращает элемент списка по указанному индексу index.
     * Если индекс выходит за пределы текущего размера списка, выбрасывается исключение IndexOutOfBoundsException.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

    /**
     * Метод isEmpty(): Проверяет, является ли список пустым.
     * Возвращает true, если размер списка равен 0, и false в противном случае.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Метод remove(int index): Удаляет элемент списка по указанному индексу index и возвращает удаленный элемент.
     * Если индекс выходит за пределы текущего размера списка, выбрасывается исключение IndexOutOfBoundsException.
     * Метод сначала с помощью метода System.arraycopy сдвигает элементы влево, чтобы удалить элемент по указанному индексу.
     * Затем последний элемент списка устанавливается в значение null и размер списка уменьшается на 1.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E removedElement = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null;
        size--;
        return removedElement;
    }

    /**
     * Метод remove(Object o): Удаляет первое вхождение указанного объекта o из списка, если он присутствует.
     * Если объект o не найден в списке, метод возвращает false.
     * Метод использует цикл для поиска объекта o и вызывает метод remove(int index), чтобы удалить элемент по найденному индексу.
     */
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод sort(Comparator<? super E> c): Сортирует элементы списка с использованием указанного компаратора c.
     * Метод использует метод Arrays.sort для сортировки элементов массива elements от 0 до size с использованием указанного компаратора.
     */
    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) elements, 0, size, c);
    }

    /**
     * Приватный метод ensureCapacity(int minCapacity): Проверяет, достаточно ли места в массиве elements для добавления минимальной вместимости minCapacity.
     * Если места недостаточно, метод увеличивает размер массива elements в два раза или до значения minCapacity, если оно больше.
     * Для этого метод использует метод Arrays.copyOf, чтобы создать новый массив с увеличенной вместимостью и скопировать элементы из старого массива в новый.
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}

