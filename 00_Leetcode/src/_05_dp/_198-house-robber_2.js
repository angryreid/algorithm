// house-robber


var rob = function (nums) { // Define the function that takes an array of numbers as input
  const n = nums.length; // Get the length of the array
  if (n === 0) return 0; // If the array is empty, return 0
  if (n === 1) return nums[0]; // If the array has only one element, return that element

  const dp = new Array(n).fill(0); // Initialize a dynamic programming array with length n and fill it with 0s
  dp[0] = nums[0]; // The maximum amount that can be robbed from the first house is the value of the first house
  dp[1] = Math.max(nums[0], nums[1]); // The maximum amount that can be robbed from the first two houses is the maximum of the values of the first two houses

  for (let i = 2; i < n; i++) { // Iterate over the rest of the houses
    dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]); // The maximum amount that can be robbed from the first i houses is the maximum of the maximum amount that can be robbed from the first i-1 houses and the sum of the maximum amount that can be robbed from the first i-2 houses and the value of the i-th house
  }

  return dp[n - 1]; // Return the maximum amount that can be robbed from all the houses
};