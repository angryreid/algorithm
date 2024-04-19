/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    const len = nums.length;
    if (len < 2) return;
    let cur = 0;
    for (let i = 0; i < len; i++) {
        const element = nums[i];
        if (element != 0) {
            nums[i] = 0;
            nums[cur++] = element;
        }
    }
};