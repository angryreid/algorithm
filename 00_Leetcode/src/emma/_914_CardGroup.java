package emma;

import java.util.ArrayList;
import java.util.List;

public class _914_CardGroup {
  /**
   * leetcode 914. 卡牌分组
   * 
   * @param deck
   * @return
   */
  public boolean hasGroupsSizeX(int[] deck) {
    int[] counts = new int[10000];
    for (int card : deck) {
      counts[card]++;
    }
    int gcd = counts[deck[0]];// First divisor
    for (int cnt : counts) {
      if (cnt != 0) {
        gcd = getGCD(gcd, cnt);// Get the greatest common divisor
        if (gcd < 2) {
          return false;
        }
      }
    }
    return true;
  }

  public int getGCD(int a, int b) {
    return a % b == 0 ? b : getGCD(b, a % b);
  }

  /**
   * Violence
   * 
   * @param deck
   * @return
   */
  static boolean hasGroupsSizeX2(int[] deck) {
    int[] counts = new int[10000];
    for (int num : deck) {
      counts[num]++;
    }
    List<Integer> list = new ArrayList();
    for (int c : counts) {
      if (c != 0) {
        list.add(c);
      }
    }
    search: for (int i = 2; i <= deck.length; i++) {
      if (deck.length % i == 0) {
        for (int v : list) {
          if (v % i != 0) {// Get the greatest common divisor i
            continue search;
          }
        }
        return true;
      }
    }
    return false;
  }
}
