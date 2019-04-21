package com.company.crackingCodeInterview.linkedList;

/**
 * Created by dkorolev on 4/21/2019.
 */
public class LinkedListNode {

    LinkedListNode nextNode;
    int data;

    public LinkedListNode(int data) {
        this.data = data;
    }

    void appendToTail(int d) {
         LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = this;
         while (n.nextNode != null) { n = n.nextNode; }
         n.nextNode = end;
         }


    //getters && setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
