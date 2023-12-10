package emma.pointer;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

public class _II_16_16_sub_sort_lcci {
  // LeetCode 16.16 link: https://leetcode.com/problems/sub-sort-lcci/

  // 1. find the first element that is smaller than the previous one, from left to right
  // 2. find the first element that is larger than the next one, from right to left
  // 3. find the min and max in the subarray
  // 4. find the first element that is larger than min in the left part
  // 5. find the first element that is smaller than max in the right part
  // 6. return the two indices

  public int[] subSort(int[] array) {
      int n = array.length;
      int r = -1;
      int l = -1;
      if (n == 0) return new int[]{l, r};
      int max = array[0];
      for (int i = 1; i < n; i++) {
          int v = array[i];
          if (v >= max) {
              max = v;
          } else {
              r = i;
          }
      }

      int min = array[n - 1];
      for (int i = n - 2; i >= 0 ; i--) {
          int v = array[i];
          if (v <= min) {
              min = v;
          } else {
              l = i;
          }
      }

      return new int[]{l, r};
  }








//  public int[] subSort(int[] array) {
//    int n = array.length;
//    int left = -1, right = -1;
//    for (int i = 1; i < n; i++) {
//      if (array[i] < array[i - 1]) {
//        left = i - 1;
//        break;
//      }
//    }
//    if (left == -1) {
//      return new int[] { -1, -1 };
//    }
//    for (int i = n - 2; i >= 0; i--) {
//      if (array[i] > array[i + 1]) {
//        right = i + 1;
//        break;
//      }
//    }
//    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//    for (int i = left; i <= right; i++) {
//      min = Math.min(min, array[i]);
//      max = Math.max(max, array[i]);
//    }
//    for (int i = 0; i < left; i++) {
//      if (array[i] > min) {
//        left = i;
//        break;
//      }
//    }
//    for (int i = n - 1; i > right; i--) {
//      if (array[i] < max) {
//        right = i;
//        break;
//      }
//    }
//    return new int[] { left, right };
//  }
}
