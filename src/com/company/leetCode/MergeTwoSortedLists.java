package com.company.leetCode;

/**
 * @author dkorolev
 *         Date: 4/15/2019
 *         Time: 5:53 PM
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode resultNode = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        System.out.println(resultNode);

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode listNode = head;

        //set until one of LinkedNodes finishes
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    listNode.next = l1;
                    l1 = l1.next;
                } else {
                    listNode.next = l2;
                    l2 = l2.next;
                }
                listNode = listNode.next;
            } else if (l1 == null) {
                listNode.next = l2;
                break;
            } else if (l2 == null) {
                listNode.next = l1;
                break;
            }
        }


        return head.next;        //to skip 1st false value for initialication
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
