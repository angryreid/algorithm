function findKDistantIndices(nums, key, k) {
  if (nums.length === 1) return [0];
  let existingMap = new Map();
  let res = [], indexArr = [];
  
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === key) {
      indexArr.push(i);
    }
  }
  for (let i = 0; i < nums.length; i++) {
    for (let j = 0; j < indexArr.length; j++) {
      if (Math.abs(i - indexArr[j]) <= k) {
        if (!existingMap.has(i)) {
          res.push(i);
          existingMap.set(i, true);
        }
      }
    }
  }
  return res;
};

console.log(findKDistantIndices([3,4,9,1,3,9,5], 9, 1));