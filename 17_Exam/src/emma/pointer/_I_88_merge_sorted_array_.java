package emma.pointer;

public class _I_88_merge_sorted_array_ { // level 1
    public void merge (int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while (i>=0 && j>=0) {
            nums1[k--] = nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        }
        while (j>=0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        // write test code here and use assert to do self-check
        _I_88_merge_sorted_array_ solution = new _I_88_merge_sorted_array_();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        solution.merge(nums1, 3, nums2, 3);
        assert nums1[0] == 1;
        assert nums1[1] == 2;
        assert nums1[2] == 2;
        assert nums1[3] == 3;
        assert nums1[4] == 5;
        assert nums1[5] == 6;
        System.out.println("self check passed!");

    }
}
