package emma;

public class _13_I_RobotArea {
  static boolean[][] visited;

  public static int movingCount(int m, int n, int k) {
    visited = new boolean[m][n];
    return dfs(0, 0, m, n, k);
  }

  private static int dfs(int x, int y, int m, int n, int k) {
    if (x >= m || y >= n || visited[x][y] || (x % 10 + x / 10 + y % 10 + y / 10) > k) {
      return 0;
    }
    visited[x][y] = true;
    return 1 + dfs(x + 1, y, m, n, k) + dfs(x, y + 1, m, n, k);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(movingCount(3, 1, 0));
  }

}
