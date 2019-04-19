package com.company.hashTable.hastTableImpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author dkorolev
 *         Date: 3/31/2019
 *         Time: 12:30 PM
 */
public class HashTableImpr {

    private List<HashNode<Integer, String>> bucketArray = new ArrayList<>();
    private int numOfBuckets;

    public HashTableImpr(int numOfBuckets) {
        this.numOfBuckets = numOfBuckets;
        this.bucketArray = new ArrayList<>(numOfBuckets) ;
        for (int i = 0; i < numOfBuckets; i++) {
            bucketArray.add(null);
        }
    }

    public boolean add(Integer key, String value) {
        HashNode<Integer, String> newNode = new HashNode<>(key, value);
        int hashedIndex = calculateHashIndex(key);
        HashNode<Integer, String> hashNode = bucketArray.get(hashedIndex);
        if (hashNode == null) {
            bucketArray.add(hashedIndex, newNode);
            return true;
        } else {
            do {
                if (Objects.equals(hashNode.key, key)) {
                    hashNode.value = value;
                    return true;
                } else {
                    hashNode = hashNode.next;
                }
            } while (hashNode.next != null);
            hashNode.next = newNode;
            return true;
        }
    }


    public String get(Integer key) {
        int hashIndex = calculateHashIndex(key);
        HashNode<Integer, String> hashNodeInBucket = bucketArray.get(hashIndex);
        if (hashNodeInBucket == null) {
            System.out.println("Not found");
            return "Not found!";
        }
        do {
            if (hashNodeInBucket.key.equals(key)) {
                System.out.println("Key: "+key+ " value: "+hashNodeInBucket.value);
                return hashNodeInBucket.value;
            } else {
                hashNodeInBucket = hashNodeInBucket.next;
            }
        } while (hashNodeInBucket.next != null);
        System.out.println("Not found");
        return "Not found!";
    }




    private int calculateHashIndex(Integer key) {
        int hashCode = key.hashCode();
        return hashCode % numOfBuckets;
    }
}