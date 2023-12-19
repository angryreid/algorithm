package emma.linkedlist;

public class _II_160_Intersection_of_Two_Linked_Lists {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) return null;
      ListNode travalA = headA;
      ListNode travalB = headB;

      while (travalA != travalB) {
          if (travalA != null) {
              travalA = travalA.next;
          } else {
              travalA = headB;
          }

          if (travalB != null) {
              travalB = travalB.next;
          } else {
              travalB = headA;
          }
      }

      return travalA;
    }

    public static void main(String[] args) {

    }
}