package com.jun.study.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            //add to
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;

        }
        return hair.next;
    }

    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};

    }
}
