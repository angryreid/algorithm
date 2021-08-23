/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

 function reverseList(head: ListNode | null): ListNode | null {
  if(head === null || head.next === null) return head;
  let newHead: ListNode = null;
  while(head != null) {
    let next = head.next;
    head.next = newHead;
    newHead = head;
    head = next;
  }
  return newHead;
};