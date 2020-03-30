package emma;

import java.util.ArrayDeque;
import java.util.Queue;

public class _1162_MapAnlaysis {

  /**
   * 1162. 地图分析 https://leetcode-cn.com/problems/as-far-from-land-as-possible/
   * 
   * @param grid
   * @return
   */
  public static int maxDistance(int[][] grid) {
    // 1. define direction: top bottom left right;
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    int xMax = grid.length, yMax = grid[0].length;
    Queue<int[]> shipQueue = new ArrayDeque<int[]>();
    for (int i = 0; i < xMax; i++) {
      for (int j = 0; j < yMax; j++) {
        if (grid[i][j] == 1) {
          shipQueue.offer(new int[] { i, j });
        }
      }
    }
    int[] ship = null;
    boolean hasOcean = false;
    while (!shipQueue.isEmpty()) {
      ship = shipQueue.poll();
      int x = ship[0], y = ship[1];
      for (int i = 0; i < 4; i++) {
        int nextX = x + dx[i];
        int nextY = y + dy[i];
        if (nextX < 0 || nextX >= xMax || nextY < 0 || nextY >= yMax || grid[nextX][nextY] != 0) {
          continue;
        }
        hasOcean = true;
        grid[nextX][nextY] = grid[x][y] + 1;
        shipQueue.offer(new int[] { nextX, nextY });
      }
    }
    if (ship == null || !hasOcean) {
      return -1;
    }

    return grid[ship[0]][ship[1]] - 1;
  }

  public static void main(String[] args) {
    int[][] map = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
    int[][] grid = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    System.out.println(maxDistance(grid));
  }
}
