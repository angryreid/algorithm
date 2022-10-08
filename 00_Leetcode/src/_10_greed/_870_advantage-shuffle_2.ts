function advantageCount(nums1: number[], nums2: number[]): number[] {
    const n: number = nums1.length, ans: Array<number> = new Array<number>(n).fill(-1)
    const idxs: Array<number> = new Array<number>(n).fill(0).map((_, index) => index).sort((a, b) => nums2[b] - nums2[a])
    nums1.sort((a, b) => a - b)
    let left: number = 0, right: number = n - 1
    for (const idx of idxs) {
        if (nums2[idx] >= nums1[right]) {
            ans[idx] = nums1[left++]
        } else {
            ans[idx] = nums1[right--]
        }
    }
    return ans
};