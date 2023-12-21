package emma.linkedlist;

public class _II_234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        ListNode mid = findMidNode(head);
        System.out.println(mid.val);
        ListNode rHead = reverseList(mid);
        ListNode lHead = head;
        ListNode rOldHead = rHead;
        while (rHead != null) {
            System.out.println(rHead.val);
            if (lHead.val != rHead.val) return false;
            lHead = lHead.next;
            rHead = rHead.next;
        }
        reverseList(rOldHead);
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
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

    /**
     * main function with below test cases
     * [1,2,3,2,1]
     */
    public static void main(String[] args) {
        _II_234_Palindrome_Linked_List solution = new _II_234_Palindrome_Linked_List();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        // node3
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(head.toString());
        System.out.println(solution.isPalindrome(head));
        System.out.println(head.toString());
    }
}
