/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
 var mergeTwoLists = function(l1, l2) {
  let root = new ListNode();
  let node = root;
  while(l1 && l2) {
    if(l1.val <= l2.val) {
      node.next = new ListNode(l1.val);
      l1 = l1.next
    } else {
      node.next = new ListNode(l2.val);
      l2 = l2.next;
    }
    node = node.next;
  }
  node.next = l1 || l2;
  return root.next;
};