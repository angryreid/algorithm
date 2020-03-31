package emma;

public class _912_SortArray {
  /**
   * https://leetcode-cn.com/problems/sort-an-array/ solved:
   * https://leetcode-cn.com/problems/sort-an-array/solution/dang-wo-tan-pai-xu-shi-wo-zai-tan-xie-shi-yao-by-s/
   * 
   * @param nums
   * @return
   * 
   */
  public static int[] sortArray(int[] nums) { // 计数排序
    int max = -50001, min = 50001;
    for (int num : nums) {
      max = Math.max(num, max);
      min = Math.min(num, min);
    }

    int[] counter = new int[max - min + 1];
    for (int num : nums) {
      counter[num - min]++;
    }

    int idx = 0;
    for (int num = min; num <= max; num++) {
      int cnt = counter[num - min];
      while (cnt-- > 0) {
        nums[idx++] = num;
      }
    }
    return nums;
  }

  public static void printArray(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i]);
      System.out.print('_');
    }
  }

  public static void main(String[] args) {
    int[] arr = { 1, 4, 2, 3, 5, 9, 8, 6, 7 };
    printArray(sortArray(arr));
  }
}
