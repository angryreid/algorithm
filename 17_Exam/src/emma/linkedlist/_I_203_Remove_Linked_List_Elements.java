package emma.linkedlist;

public class _I_203_Remove_Linked_List_Elements {

  public ListNode removeElements(ListNode head, int val) {
    ListNode newHead = null;
    ListNode pre = null;
    while(head != null) {
        if (head.val != val) {
            if (newHead == null) {
                newHead = head;
            }
            pre = head;
        } else {
            if (newHead != null) {
                pre.next = head.next;
            }
        }
        head = head.next;
    }

    if (pre != null)
        pre.next = null;

    return newHead;
  }


  /**
   * Enhanced version
   * @param head
   * @param val
   * @return
   */
  public ListNode removeElements2(ListNode head, int val) {
    ListNode newHead = null;
    ListNode pre = null;
    while(head != null) {
        if (head.val != val) {
            if (newHead == null) {
                newHead = head;
                pre = head;
            } else {
                pre.next = head;
                pre = head;
            }
        }
        head = head.next;
    }

    if (pre != null)
        pre.next = null;

    return newHead;
  }

/**
 * Enhanced version
 */
  public ListNode removeElements3(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        while(head != null) {
            if (head.val != val) {
                pre = pre.next = head;
            }
            head = head.next;
        }

        if (pre != null)
            pre.next = null;

        return newHead.next;
    }

  /**
   * Definition for singly-linked list.
   *
   *
   */
  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  // main function for local test
  public static void main(String[] args) {
    // write test code here and use assert to do self-check
    _I_203_Remove_Linked_List_Elements solution = new _I_203_Remove_Linked_List_Elements();
    ListNode head = new ListNode(1);
    ListNode node1 = new ListNode(2);
    ListNode node2 = new ListNode(6);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;

    ListNode newHead = solution.removeElements(head, 6);
    assert newHead.val == 1;
    assert newHead.next.val == 2;
    assert newHead.next.next.val == 3;
    assert newHead.next.next.next.val == 4;
    assert newHead.next.next.next.next.val == 5;
    System.out.println("self check passed!");

  }
}
