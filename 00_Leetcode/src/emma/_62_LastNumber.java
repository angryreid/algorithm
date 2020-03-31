package emma;

import java.util.LinkedList;
import java.util.List;

public class _62_LastNumber {

  /**
   * 时间复杂度是 O(n^2)
   * 
   * @param n
   * @param m
   * @return
   */
  public static int lastRemaining(int n, int m) {
    List<Integer> list = new LinkedList<Integer>();
    for (int i = 0; i < n; i++) {
      list.add(i);
    }
    int idx = 0;
    while (n > 1) {
      idx = (idx + m - 1) % n;
      list.remove(idx);
      n--;
    }
    return list.get(0);
  }

  public int lastRemaining2(int n, int m) {
    int ans = 0;
    // 最后一轮剩下2个人，所以从2开始反推
    for (int i = 2; i <= n; i++) {
      ans = (ans + m) % i;
    }
    return ans;
  }

  public static void main(String[] args) {
    lastRemaining(10, 2);
  }
}
