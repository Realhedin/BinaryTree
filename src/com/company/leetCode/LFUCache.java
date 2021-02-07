package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Least Frequency Used cache eviction policy.
 * cache have size = capacity value,
 * if capacity value exceeded, then least frequency used value should be removed.
 *  We use Node class (two directional analogue of LinkedList) to have extended cache object.
 *  withing Map<Integer,Node> cache.
 *  And we have helper frequency map with LinkedList for Node: Map<Integer, DoubleLinkedList> frequencyMap.
 *  https://leetcode.com/problems/lfu-cache
 */
public class LFUCache {
    final int capacity;
    int minFrequency;
    //cache
    Map<Integer, Node> cache;
    //map correlation frequency to existing Nodes for this frequency
    Map<Integer, DoubleLinkedList> frequencyMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>(capacity);
        this.frequencyMap = new HashMap<>();
    }



    /** get node value by key,
     * and then update node frequency as well as relocate that node **/
    public int get(int key) {
        Node curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNodeInFrequencyMap(curNode);
        return curNode.val;
    }

    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
    public void put(int key, int value) {
        // corner case: check cache capacity initialization
        if (capacity == 0) {
            return;
        }

        Node curNode = cache.get(key);
        if (curNode != null) {
            curNode.val = value;
            updateNodeInFrequencyMap(curNode);
        } else {
            if (cache.size() >= capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                Node deleteNode = minFreqList.removeTail();
                cache.remove(deleteNode.key);
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            Node newNode = new Node(key, value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    /**
     * Update Node in frequency map.
     * Remove from current, increase frequency and add back.
     */
    public void updateNodeInFrequencyMap(Node curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }

        curNode.frequency++;
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }

    /*
     * @param key: node key
     * @param val: node value
     * @param frequency: frequency count of current node
     * (all nodes connected in same double linked list has same frequency)
     * @param prev: previous pointer of current node
     * @param next: next pointer of current node
     * */
    static class Node {
        int key;
        int val;
        int frequency;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    /*
     * @param listSize: current size of double linked list
     * @param head: head node of double linked list
     * @param tail: tail node of double linked list
     * */
    static class DoubleLinkedList {
        int listSize;
        Node head;
        Node tail;
        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        /** add new node into head of list and increase list size by 1 **/
        public void addNode(Node curNode) {
            Node nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        /** remove input node and decrease list size by 1**/
        public void removeNode(Node curNode) {
            curNode.prev.next = curNode.next;
            curNode.next.prev = curNode.prev;
            listSize--;
        }

        /** remove tail node **/
        public Node removeTail() {
            // DO NOT FORGET to check list size
            if (listSize > 0) {
                Node tailNode = tail.prev;
                removeNode(tailNode);
                return tailNode;
            }
            return null;
        }
    }
}
