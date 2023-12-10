package emma.pointer;

public class _I_88_merge_sorted_array_ { // level 1
    public void merge (int[] nums1, int m, int[] nums2, int n) { // Define the method that takes two sorted arrays (nums1 and nums2) and their lengths (m and n) as input
        int i = m-1, j = n-1, k = m+n-1; // Initialize pointers for the ends of nums1, nums2, and the merged array
        while (i>=0 && j>=0) { // While there are elements left in both arrays
            nums1[k--] = nums1[i]>nums2[j]?nums1[i--]:nums2[j--]; // Compare the last elements of nums1 and nums2, put the larger one at the end of the merged array, and move the corresponding pointer
        }
        while (j>=0) { // While there are elements left in nums2
            nums1[k--] = nums2[j--]; // Put the last element of nums2 at the end of the merged array and move the pointer
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
