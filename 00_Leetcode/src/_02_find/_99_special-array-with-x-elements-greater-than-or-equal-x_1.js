//https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/submissions/

function specialArray(nums)  {
  nums.sort((a, b) => (a - b));
  const len = nums.length;
  if (nums[0] >= len) return len;
  for (let i = 1, j = len - 1; i < len; i++, j--) {
      if (nums[i] >= j && nums[i - 1] < j) {
          return j;
      }
  }

  return -1;
};

console.log(specialArray([3,6,7,7,0])); // -1
console.log(specialArray([0,4,3,0,4])); // 3
console.log(specialArray([3,5])); // 2
console.log(specialArray([0,0])); // -1