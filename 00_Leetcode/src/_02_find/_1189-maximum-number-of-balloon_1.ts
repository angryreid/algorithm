function maxNumberOfBalloons(text: string): number {
  const balloon = 'balloon';
  let countMap = new Map<string, number>();
  let repeatMap = new Map<string, number>();
  let res = Number.MAX_SAFE_INTEGER;
  for (let t of balloon) {
    if (!countMap.has(t)) {
      countMap.set(t, 0);
    }
    if (!repeatMap.has(t)) {
      repeatMap.set(t, 1);
    } else {
      repeatMap.set(t, repeatMap.get(t) + 1);
    }
  }

  for (let t of text) {
    if(countMap.has(t)) {
      countMap.set(t, countMap.get(t) + 1);
    }
  }

  countMap.forEach((count, key) => {
    res = Math.min(res, Math.floor(count / repeatMap.get(key)));
  })
  return res;
};