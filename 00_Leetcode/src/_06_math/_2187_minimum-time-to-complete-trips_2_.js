function minimumTime(time, totalTrips) {
  time.sort((a , b) => a - b);
  let t = time[0], res = 0;
  while (res <= totalTrips) {
    for (let i = 0; i < time.length; i++) {
      if (t >= time[i]) {
        res += Math.floor(t / time[i]);
      }
    }
    if (res >= totalTrips) {
      break;
    } else {
      res = 0;
      t++;
    }
  }
  return t;
};

// console.log(minimumTime([5, 10, 10], 9)); // 25
// console.log(minimumTime([9, 3, 10, 5], 2)); // 5
// console.log(minimumTime([2], 1));
// console.log(minimumTime([1,2,3], 5));