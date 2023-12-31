/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} subRoot
 * @return {boolean}
 */
var isSubtree = function(root, subRoot) {
  if (!root || !subRoot) return false;
  console.log(postTraverseStr(root))
  return postTraverseStr(root).includes(postTraverseStr(subRoot));
};



var postTraverseStr = function (node, str = '') {
  if (!node.left) {
      str += '#!';
  } else {
      str = postTraverseStr(node.left, str);
  }
  if (!node.right) {
      str += '#!';
  } else {
      str = postTraverseStr(node.right, str);
  }
  str += node.val;
  str += '!';
  return str; 
}