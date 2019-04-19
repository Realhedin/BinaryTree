package com.company.hashTable.hastTableImpr;

/**
 * @author dkorolev
 *         Date: 3/31/2019
 *         Time: 12:29 PM
 */
public class HashNode<K,V> {

    K key;
    V value;

    HashNode<K,V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}