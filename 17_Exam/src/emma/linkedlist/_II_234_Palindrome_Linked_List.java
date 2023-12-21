package emma.linkedlist;

public class _II_234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        ListNode mid = findMidNode(head);
        ListNode rHead = reverseList(mid);
        ListNode lHead = head;
        while (rHead != null) {
            if (lHead.val != rHead.val) return false;
            lHead = lHead.next;
            rHead = rHead.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head.next;
        head.next = null;
        return newHead;
    }

    private ListNode findMidNode(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
