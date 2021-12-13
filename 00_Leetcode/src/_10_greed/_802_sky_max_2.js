function maxIncreaseKeepingSkyline(grid) {
  const n = grid.length;
  const maxXline = new Array(n).fill(0);
  const maxYline = new Array(n).fill(0);
  let result = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      maxXline[i] = Math.max(grid[i][j], maxXline[i]);
      maxYline[i] = Math.max(grid[j][i], maxYline[i]);
    }
  }

  console.log(maxXline)
  console.log(maxYline)
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      result += Math.min(maxYline[j], maxXline[i]) - grid[i][j];
    }
  }
  return result;
}

const grid = [
  [8, 4, 8, 7],
  [7, 4, 7, 7],
  [9, 4, 8, 7],
  [3, 3, 3, 3],
];

const grid1 = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]

const grid2 = [[59,88,44],[3,18,38],[21,26,51]];

console.log(maxIncreaseKeepingSkyline(grid2));
