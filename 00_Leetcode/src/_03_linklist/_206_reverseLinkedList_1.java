package _03_linklist;

public class _206_reverseLinkedList_1 {
    private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head.next;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

    }
}
