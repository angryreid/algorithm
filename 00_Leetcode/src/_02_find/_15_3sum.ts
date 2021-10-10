function threeSum(nums: number[]): number[][] {
  let result: number[][] = [];
  if(nums.length < 3) return result;

  for(let i = 0; i < nums.length; i++) {
    for(let j = i+1; j < nums.length; j++) {
      for(let k = j+1; k < nums.length; k++){
        if((nums[i] + nums[j] + nums[k]) === 0)
          result.push([nums[i], nums[j], nums[k]]);
      }
    }
  }
  return result;
};
