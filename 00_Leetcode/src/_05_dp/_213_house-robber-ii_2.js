// house-robber-ii

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  const n = nums.length;
  if (n === 0) return 0;
  if (n === 1) return nums[0];

  const dp = new Array(n).fill(0);
  dp[0] = nums[0];
  dp[1] = Math.max(nums[0], nums[1]);

  for (let i = 2; i < n - 1; i++) {
    dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
  }
  const ans = dp[n - 2];

  dp[0] = 0;
  dp[1] = nums[1];
  for (let i = 2; i < n; i++) {
    dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
  }

  return Math.max(ans, dp[n - 1]);
};
