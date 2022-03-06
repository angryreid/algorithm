function minimalKSum(nums, k) {
  let res = 0;
  if (nums.length < 2) {
    const first = nums[0];
    if (first > k) {
      return Math.floor(k * (k + 1) / 2);
    } else {
      console.log('e')
      return Math.floor(first * (first + 1) / 2) + 5;
    }
  }
  nums.sort((a, b) => (a - b));
  if (nums[0] !== 1) nums.unshift(0);
  for (let i = 0; i < nums.length; i++) {
    if (k <= 0) {
      break;
    } else {
      const t = nums[i + 1];
      if (t !== undefined) {
        let s = nums[i];
        if (t - s > 1 && k > 0) {
          s++;
          const step = (t - s) > k ? k : t - s ;
          k = k - step;
          res += s * step + Math.floor((step - 1) * step / 2);
        }
      } else {
        let s = nums[i];
        if (k > 0) {
          s++;
          res += s * k + Math.floor((k - 1) * k / 2);
        }
      }
    }
  }
  return res;
};

// console.log(minimalKSum([1,4,25,10,25], 2));
// console.log(minimalKSum([5,6], 6));
// console.log(minimalKSum([1], 1000000000));

// console.log(minimalKSum([96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84]
  // ,35))

  console.log(minimalKSum([1000000000], 1000000000))