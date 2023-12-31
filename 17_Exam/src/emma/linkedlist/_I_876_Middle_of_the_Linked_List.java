package emma.linkedlist;

import emma.common.ListNode;

public class _I_876_Middle_of_the_Linked_List {
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
