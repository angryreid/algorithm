function arrangeCoins(n: number): number {
  if(n < 1) return 0;
  let i = 1;
  while(true) {
    const sum = (i*(i+1)/2);
    if(n > sum){
      i++;
    } else if(n < sum) {
      i--;
      break
    }else {
      break;
    }
  }
  return i;
};
