package com.company.hashTable;

/**
 * @author dkorolev
 *         Date: 3/30/2019
 *         Time: 2:52 PM
 */
public class HashTableWithArray {

    int capacity;
    int[] array;

    public HashTableWithArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }


    public void add(int key, int value) {
        array[key % capacity] = value;
    }


    public int getValue(int key) {
        return array[key % capacity];
    }
}