package emma.binarysearch;

public class _II_162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r ) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println(l + "- " + r);
        if (nums[l] > nums[r]) return l;
        return r;
    }

    // main function for local test
    public static void main(String[] args) {
        // write test code here and use assert to do self-check
        _II_162_Find_Peak_Element solution = new _II_162_Find_Peak_Element();
        int[] nums = new int[]{1,2,3,1};
        int[] nums2 = new int[]{1,2,1,3,5,6,4};
        int[] nums3 = new int[]{1,2,3,4,5,6,7};

        assertFunc(2, solution.findPeakElement(nums));
        assertFunc(5, solution.findPeakElement(nums2));
        assertFunc(6, solution.findPeakElement(nums3));
        System.out.println("self check passed!");

        
    }

    // define asset function
    private static void assertFunc(int expected, int actual) {
        assert expected == actual : String.format("expected is %s, actual is %s", expected, actual);
    }
}
