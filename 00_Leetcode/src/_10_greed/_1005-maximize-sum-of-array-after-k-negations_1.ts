function largestSumAfterKNegations(nums: number[], k: number): number {
  nums.sort((a, b) => Math.abs(b) - Math.abs(a));
  for (let i = 0; i < nums.length; i++) {
    if (k > 0) {
      if (nums[i] < 0) {
        nums[i] = -nums[i];
        k--;
      }
    } else {
      break;
    }
  }

  if (k > 0 && k % 2 === 1) {
    nums[nums.length - 1] = -nums[nums.length - 1];
  }

  return nums.reduce((a, b) => a + b);
};