package com.zhonghuasheng.datastructure.customer;

import java.util.ArrayList;

public class ArrayInsert {

    public static void main(String[] args) {
        MyArray myArray = new MyArray(4);
        myArray.insert(3, 0);
        myArray.insert(4, 1);
        myArray.insert(6, 2);
        myArray.insert(1, 3);
        myArray.print();
        myArray.insert(13, 4);
        myArray.insert(14, 5);
        myArray.insert(16, 6);
        myArray.insert(11, 7);
        myArray.print();
        myArray.insert(5, 5);
        myArray.print();
    }
}

class MyArray {
    int size;
    int[] array;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);

    }
    public void insert(int element, int index) {
        if (index > array.length || index < 0) {
            throw new IndexOutOfBoundsException("数组越界");
        }

        if (this.size >= array.length) {
            resize();
        }

        for (int i = this.size - 1; i >= index ; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    private void resize() {
        int[] newArray = new int[this.size * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println();
    }
}
