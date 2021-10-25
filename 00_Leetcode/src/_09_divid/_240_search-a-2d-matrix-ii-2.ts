function searchMatrix(matrix: number[][], target: number): boolean {
  const m = matrix.length;
  if (m === 0) {
    return false;
  }

  const n = matrix[0].length;

  if (n === 0) {
    return false;
  }

  let i = m - 1, j = 0;
  while (i >= 0 && j < n) {
    if(matrix[i][j] === target) {
      return true;
    } else if (matrix[i][j] < target) {
      j += 1;
    } else {
      i -= 1;
    }
  }
  return false;
};