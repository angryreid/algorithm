function singleNumber(nums: number[]): number[] {
  // return nums.filter(num => nums.indexOf(num) === nums.lastIndexOf(num));
  let numMap = new Map<number, number>();
  let result: number[] = [];
  nums.forEach(v => {
    if (numMap.has(v)) {
      numMap.delete(v);
    } else {
      numMap.set(v, v);
    }
  });
  return [...numMap.keys()];
};