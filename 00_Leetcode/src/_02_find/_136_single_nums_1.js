function singleNumber(nums) {
  if (nums.length === 1) return nums[0];

  let numIndex = -1;
  for (let i = 0; i < nums.length; i++) {
    if (nums.indexOf(nums[i]) === nums.lastIndexOf(nums[i])) {
      numIndex = i;
      break;
    }
  }
  return nums[numIndex];
};

console.log(singleNumber([2,2,1]));