package emma.linkedlist;

public class _II_86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode left = new ListNode(0);
        ListNode leftTail = left;
        ListNode right = new ListNode(0);
        ListNode rigthTail = right;
        
        while (head != null) {
            if (head.val < x) {
                leftTail = leftTail.next = head;
            } else {
                rigthTail = rigthTail.next = head;
            }
            head = head.next;
        }

        if (rigthTail != null) {
            rigthTail.next = null;
        }

        leftTail.next = right.next;
        return left.next;
    }
}
