package com.company.leetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * Implement LRU (Least Recently Used) cache.
 * cache have size = capacity value,
 * if capacity value exceeded, then least recently used value should be removed.
 * For helping purposes of understanding which value is recently used,
 * we use Node class (two directional analogue of LinkedList) with head and tail values.
 * https://leetcode.com/problems/lru-cache/
 *
 */
public class LRUCache {

    private Node head;
    private Node tail;
    private Map<Integer, Node> nodeMap;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            //get Node, remove node from cache and add it into beginning
            Node node = nodeMap.get(key);
            removeNode(node);
            addNodeAfterHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            /* if exists, then we remove this object and
            add to the head and update value */
            Node node = nodeMap.get(key);
            removeNode(node);
            node.value = value;
            addNodeAfterHead(node);
        } else {
            Node node = new Node(key, value);
            //first check, if capacity exceeded
            if (nodeMap.size() >= capacity) {
                //remove lru from map and from cache
                nodeMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            //add new object
            nodeMap.put(key, node);
            addNodeAfterHead(node);
        }
    }

    /**
     * add current node after Head.
     */
    private void addNodeAfterHead(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;

    }

    /**
     * remove node from linked list
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /* helper */
    static class Node {
        private Node prev;
        private Node next;
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
