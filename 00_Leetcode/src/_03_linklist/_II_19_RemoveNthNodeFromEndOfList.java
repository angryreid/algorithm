package _03_linklist;

import _03_linklist.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode newHead = new ListNode(-1, head);
        ListNode pioneer = head,successor = head,guard = newHead;
        for (int i = 0; i < n; i++) {
           if (pioneer != null) {
               pioneer = pioneer.next;
           } else {
               return null;
           }
        }
        while (pioneer != null) {
            pioneer = pioneer.next;
            successor = successor.next;
            guard = guard.next;
        }

        guard.next = successor.next;

        return newHead.next;
    }
}