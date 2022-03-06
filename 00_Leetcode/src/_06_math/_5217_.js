function sortJumbled(mapping, nums) {
  const map = new Map();
  for (let i = 0; i < nums.length; i++) {
    if (!map.has(nums[i])) {
      const numStr = nums[i].toString().split('');
      let str = ''
      for (let c of numStr) {
        str += mapping[Number(c)];
      }
      map.set(nums[i], Number(str));
    }
  }
  return nums.sort((a, b) => (map.get(a) - map.get(b)));
};

console.log(sortJumbled([8,9,4,0,2,1,3,5,7,6], [991,338,38]))