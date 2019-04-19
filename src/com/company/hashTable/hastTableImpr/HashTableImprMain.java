package com.company.hashTable.hastTableImpr;

/**
 * @author dkorolev
 *         Date: 3/31/2019
 *         Time: 12:50 PM
 */
public class HashTableImprMain {
    public static void main(String[] args) {

        HashTableImpr hashTableImpr = new HashTableImpr(10);
        hashTableImpr.add(1, "aaa");
        hashTableImpr.add(2, "bbb");
        hashTableImpr.get(1);
        hashTableImpr.add(1, "ccc");
        hashTableImpr.get(1);
        hashTableImpr.get(3);
    }
}