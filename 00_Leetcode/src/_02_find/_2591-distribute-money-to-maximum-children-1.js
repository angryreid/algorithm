// distribute-money-to-maximum-children

/**
 * @param {number} money
 * @param {number} children
 * @return {number}
 *
 * 所有的钱都必须被分配。
 * 每个儿童至少获得 1 美元。
 * 没有人获得 4 美元。
 */

var check = function (num, money, children) {
  const eightNumsMoney = num * 8;
  const remainMoney = money - eightNumsMoney;
  const remainChildren = children - num;
  if (remainMoney < 0 || remainChildren < 0) return false;
  if (remainMoney > 0 && remainChildren === 0) return false;
  if (remainMoney < remainChildren || (remainMoney === 4 && remainChildren === 1)) return false;
  return true;
};

var distMoney = function (money, children) {
  let left = 0;
  let right = children;
  let ans = -1;
  while (left <= right) {
    const mid = left + ((right - left) >> 1);
    if (check(mid, money, children)) {
      ans = mid;
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return ans;
};

console.log(distMoney(100, 10));
