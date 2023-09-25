// house-robber-iv
// https://leetcode.cn/problems/house-robber-iv/solutions/2093952/er-fen-da-an-dp-by-endlesscheng-m558/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minCapability = function (nums, k) {
  let lower = Math.min(...nums);
  let upper = Math.max(...nums);
  while (lower <= upper) {
    const middle = Math.floor((lower + upper) / 2);
    let count = 0;
    let visited = false;
    for (const x of nums) {
      if (x <= middle && !visited) {
        count++;
        visited = true;
      } else {
        visited = false;
      }
    }
    if (count >= k) {
      upper = middle - 1;
    } else {
      lower = middle + 1;
    }
  }
  return lower;
};
