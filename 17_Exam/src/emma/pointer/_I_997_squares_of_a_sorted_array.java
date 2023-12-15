package emma.pointer;

public class _I_997_squares_of_a_sorted_array {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int left = 0, right = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            int leftP = nums[left] * nums[left];
            int rightP = nums[right] * nums[right];
            if (leftP >= rightP) {
                res[i] = leftP;
                left++;
            } else {
                res[i] = rightP;
                right--;
            }
        }
        return res;
    }
}
