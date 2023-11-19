
/**
 * @param {number[]} array
 * @return {number[]}
 * https://leetcode.cn/problems/sub-sort-lcci/
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 */
var subSort = function(array) {
  const len = array.length;
  if (len === 0) return [-1, -1];
  let max = array[0];
  let min = array[len - 1];
  let left = -1;
  let right = -1;
  for (let i = 1; i < len; i++) {
    const v = array[i];

    if (v >= max) {
      max = v;
    } else {
      right = i;
    }
  }

  if (right === -1) return [-1, -1];

  for (let i = len - 2; i >= 0; i--) {
    const v = array[i];
    if (v <= min) {
      min = v;
    } else {
      left = i;
    }
  }
  return [left, right];
};

console.log(subSort([1,2,4,7,10,11,7,12,6,7,16,18,19]))