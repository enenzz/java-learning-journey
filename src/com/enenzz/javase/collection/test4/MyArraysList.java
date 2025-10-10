package com.enenzz.javase.collection.test4;

import java.util.Arrays;

public class MyArraysList<E> {
    Object[] obj = new Object[10];
    int size;

    public boolean add(E e) {
        obj[size++] = e;
        return true;
    }

    public E get(int index) {
        return (E)obj[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(obj);
    }
}
