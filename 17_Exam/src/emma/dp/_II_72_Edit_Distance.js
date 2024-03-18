/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 * 
 */

// 1. DP
var minDistance = function(word1, word2) {
    let m = word1.length;
    let n = word2.length;
    let dp = new Array(m+1).fill(0).map(()=>new Array(n+1).fill(0));
    for (let i = 0; i <= m; i++) {
        dp[i][0] = i;
    }
    for (let j = 0; j <= n; j++) {
        dp[0][j] = j;
    }
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (word1[i-1] === word2[j-1]) {
                dp[i][j] = dp[i-1][j-1];
            } else {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
            }
        }
    }
    return dp[m][n];
}

// 2. DP with 1D array

var minDistance = function(word1, word2) {
    let m = word1.length;
    let n = word2.length;
    let dp = new Array(n+1).fill(0);
    for (let j = 0; j <= n; j++) {
        dp[j] = j;
    }
    for (let i = 1; i <= m; i++) {
        let pre = dp[0];
        dp[0] = i;
        for (let j = 1; j <= n; j++) {
            let temp = dp[j];
            if (word1[i-1] === word2[j-1]) {
                dp[j] = pre;
            } else {
                dp[j] = Math.min(pre, dp[j], dp[j-1]) + 1;
            }
            pre = temp;
        }
    }
    return dp[n];
}

// 3. Recursion with memoization

var minDistance = function(word1, word2) {
  let m = word1.length;
  let n = word2.length;
  let memo = new Array(m).fill(0).map(()=>new Array(n).fill(-1));
  return dfs(word1, word2, m-1, n-1, memo);
}

function dfs(word1, word2, i, j, memo) {
  // base cases
  if (i < 0) return j + 1;
  if (j < 0) return i + 1;

  // if the result is already in the memo, return it
  if (memo[i][j] !== -1) return memo[i][j];

  if (word1[i] === word2[j]) {
    memo[i][j] = dfs(word1, word2, i - 1, j - 1, memo);
  } else {
    let insert = dfs(word1, word2, i, j - 1, memo);
    let deleteChar = dfs(word1, word2, i - 1, j, memo);
    let replace = dfs(word1, word2, i - 1, j - 1, memo);
    memo[i][j] = Math.min(insert, deleteChar, replace) + 1;
  }

  return memo[i][j];
}

// 4. Recursion

var minDistance = function(word1, word2) {
  return recursion(word1, word2, word1.length, word2.length);
}

function recursion(word1, word2, i, j) {
  // base cases
  if (i === 0) return j;
  if (j === 0) return i;

  if (word1[i-1] === word2[j-1]) {
    return recursion(word1, word2, i - 1, j - 1);
  } else {
    let insert = recursion(word1, word2, i, j - 1);
    let deleteChar = recursion(word1, word2, i - 1, j);
    let replace = recursion(word1, word2, i - 1, j - 1);
    return Math.min(insert, deleteChar, replace) + 1;
  }
}
