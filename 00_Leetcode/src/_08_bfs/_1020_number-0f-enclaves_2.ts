function numEnclaves(grid: number[][]): number {
  const m = grid.length, n = grid[0].length, dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]];
  let res = 0, stack: number[][] = [];

  for (let i = 0; i < m; i++) {
    if(grid[i][0] === 1) {
      grid[i][0] = 0;
      stack.push([i , 0]);
    }

    if(grid[i][n - 1] === 1) {
      grid[i][n - 1] = 0;
      stack.push([i , n -1]);
    }
  }

  for (let i = 0; i < n; i++) {
    if(grid[0][i] === 1) {
      grid[0][i] = 0;
      stack.push([0 , i]);
    }

    if(grid[m - 1][i] === 1) {
      grid[m - 1][i] = 0;
      stack.push([m - 1 , i]);
    }
  }

  while (stack.length !== 0) {
    const curPoint = stack.shift();
    for (let dir of dirs) {
      const nextPointX = curPoint[0] + dir[0];
      const nextPointY = curPoint[1] + dir[1];
      if (nextPointX >= 0 && nextPointY >= 0 && nextPointX < m && nextPointY < n && grid[nextPointX][nextPointY] !== 0) {
        grid[nextPointX][nextPointY] = 0;
        stack.push([nextPointX, nextPointY]);
      }
    }
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
