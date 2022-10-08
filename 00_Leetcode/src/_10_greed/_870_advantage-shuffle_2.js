function advantageCount(nums1, nums2) {
    const n = nums1.length,
        ans = new Array(n).fill(-1);
    const idxs = new Array(n)
        .fill(0)
        .map((_, index) => index)
        .sort((a, b) => nums2[b] - nums2[a]);
    console.log(idxs); // Sort with largest number index from the begining.
    nums1.sort((a, b) => a - b);
    let left = 0,
        right = n - 1;
    for (const idx of idxs) {
        if (nums2[idx] >= nums1[right]) {
            ans[idx] = nums1[left++];
        } else {
            ans[idx] = nums1[right--];
        }
    }
    return ans;
}
console.log(advantageCount([2, 7, 11, 15], [1, 10, 4, 11])); // Expected: [2,11,7,15]
