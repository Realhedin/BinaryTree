package com.company.crackingCodeInterview.linkedList;

/**
 * Created by dkorolev on 4/21/2019.
 */
public class DeleteNode {

    public static void main(String[] args) {
        LinkedListNode linkedListNode = new LinkedListNode(1);
        linkedListNode.appendToTail(2);
        linkedListNode.appendToTail(3);
        linkedListNode.appendToTail(4);
        linkedListNode.appendToTail(5);

        deleteNode(linkedListNode, 3);

        System.out.println(linkedListNode);
    }

    public static void deleteNode(LinkedListNode node, int data) {

        LinkedListNode nextNode;
        while (node.nextNode !=null) {
            nextNode = node.nextNode;
            if (node.data == data) {
                node.nextNode = nextNode.nextNode;
                node.data = nextNode.data;
                return;
            }
            node = nextNode;
        }

    }
}
