function numEnclaves(grid: number[][]): number {
  const m = grid.length, n = grid[0].length;
  let res = 0;
  for (let i = 0; i < m ; i++) {
    dfs(grid, i, 0);
    dfs(grid, i, n - 1);
  }

  for (let i = 0; i < n ; i++) {
    dfs(grid, 0, i);
    dfs(grid, m - 1, i);
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === 1) {
        res++;
      }
    }
  }
  return res;
};

function dfs(grid: number[][], x: number, y: number): void {
  if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] === 0) return;

  grid[x][y] = 0;
  dfs(grid, x + 1, y);
  dfs(grid, x - 1, y);
  dfs(grid, x, y + 1);
  dfs(grid, x, y - 1);
}