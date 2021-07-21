package offer;
// https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/gong-shui-san-xie-zhao-liang-tiao-lian-b-ifqw/

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class _52_linklist_first_public_node {
//    public ListNode getIntersectionNode(ListNode a, ListNode b) {
//        int c1 = 0, c2 = 0;
//        ListNode ta = a, tb = b;
//        while (ta != null && c1++ >= 0) ta = ta.next;
//        while (tb != null && c2++ >= 0) tb = tb.next;
//        int d = c1 - c2;
//        if (d > 0) {
//            while (d-- > 0) a = a.next;
//        } else if (d < 0) {
//            d = -d;
//            while (d-- > 0) b = b.next;
//        }
//        while (a != b) {
//            a = a.next;
//            b = b.next;
//        }
//        return a;
//    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2){
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
