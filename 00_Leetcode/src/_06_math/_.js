// function mostFrequent(nums, key) {
//   let max = 0, res = 0, l = 0, r = 0;
//   while (r < nums.length) {
//     if (nums[r] == key) {
//       const target = nums[r + 1];
//       l = r;
//       r++;
//       while (nums[r] === target) r++;
//       if (r - l > max) {
//         res = target;
//       }
//     } else {
//       r++;
//     }
//   }
//   return res;
// }


function mostFrequent(nums, key) {
  let max = 0, res = 0, l = 0, r = 0;
  let mapCount = new Map();
  while (r < nums.length) {
    if (nums[r] == key) {
      const target = nums[r + 1];
      l = r;
      r++;
      while (nums[r] === target && r < nums.length) r++;
      const num = mapCount.get(target);
      if (!mapCount.has(target)) {
        mapCount.set(target, r - l);
      } else {
        mapCount.set(target,num + r - l);
      }
      if (num > max) {
        max = num;
        res = target;
      }
    } else {
      r++;
    }
  }
  return res;
};

// console.log(mostFrequent([1,100,200,1,100], 1))
// console.log(mostFrequent([1,100,2], 100))
// console.log(mostFrequent([2,2,2,2,3,2,6,6,6,6,6], 2))
console.log(mostFrequent([11,22,11,22,11], 11))