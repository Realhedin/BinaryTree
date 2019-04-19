package com.company.hashTable;

/**
 * @author dkorolev
 *         Date: 3/30/2019
 *         Time: 2:56 PM
 */
public class HashTableMain {

    public static void main(String[] args) {
        HashTableWithArray hashTableWithArray = new HashTableWithArray(9);
        hashTableWithArray.add(1,6);
        hashTableWithArray.add(2,7);
        hashTableWithArray.add(3,8);
        hashTableWithArray.add(4,9);
        System.out.println(hashTableWithArray.getValue(5));

    }
}