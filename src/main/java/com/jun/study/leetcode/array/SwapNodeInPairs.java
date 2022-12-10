package com.jun.study.leetcode.array;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs
 */
public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null && prev.next.next != null) { // loop end condition
            //double point
            ListNode node1 = prev.next;
            ListNode node2 = node1.next;
            //keep subhead
            ListNode subHead = node2.next;
            //swap
            node2.next = node1;
            node1.next = subHead;
            //loop
            prev.next = node2;
            prev = node1;
        }
        return dummyHead.next;
    }

    public ListNode swapPairs0928(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode move = dummyHead;
        while (move.next != null && move.next.next != null) {
            ListNode node1 = move.next;
            ListNode node2 = move.next.next;
            ListNode nextHead = node2.next;
            //swap
            node2.next = node1;
            node1.next = nextHead;
            // loop
            move.next = node2;
            move = node1;

        }

        return dummyHead.next;

    }

}

