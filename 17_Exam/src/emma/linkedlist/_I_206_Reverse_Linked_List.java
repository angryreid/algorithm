package emma.linkedlist;

public class _I_206_Reverse_Linked_List {
  if (head == null || head.next == null) return head;
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}
