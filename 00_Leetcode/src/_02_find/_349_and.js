/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
  if(!nums1 || !nums1.length || !nums2 || !nums2.length)
    return [0];

  const nums1Set = new Set(nums1);
  const reSet = new Set();

  for(let i = nums2.length - 1; i >= 0; i++) {
    if(nums1Set.has(nums2[i]))
      reSet.add(nums2[i]);
  }
  return Array.from(reSet);
};
