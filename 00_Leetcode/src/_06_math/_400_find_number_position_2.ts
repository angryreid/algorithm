function findNthDigit(n: number): number {
  let digital = 1, base = 9;

  while (n > digital * base) {
    n -= digital * base;
    digital++;
    base *= 10;

    if (Number.MAX_SAFE_INTEGER / base < digital) {
      break;
    }
  }

  n--;
  const realNum = 10 ** (digital - 1) + Math.floor(n / digital), index = n % digital;
  return Number(realNum.toString()[index]);
};