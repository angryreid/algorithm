// function isHappy(n: number): boolean {
//   let numAr: number[] = String(n).split('').map(v => Number(v));
//   let set = new Set<number>();
//   set.add(n);
//   while(true) {
//     const len = numAr.length;
//     let sum = numAr.reduce((p, c) => (Math.pow(p, 2) + Math.pow(c, 2)));
//     if(sum === 1) {
//         return true;
//       } else if (set.has(sum)){
//         return false;
//       } else {
//         set.add(sum);
//       }
//     numAr = String(sum).split('').map(v => Number(v));
//   }
// };


function isHappy(n) {
  let numAr = String(n).split('').map(v => Number(v));
  let set = [];
  set.push(n);
  while(true) {
    console.log('numbers', numAr)
    let sum = 0;
    if(numAr.length > 1) {

      sum = numAr.reduce((p, c) => (Math.pow(p, 2) + Math.pow(c, 2)));
      
    } else {
      sum = Math.pow(numAr[0], 2);
    }
    if(sum === 1) {
        return true;
      } else if (set.indexOf(sum) !== -1){
        console.log(sum)
        return false;
      } else {
        set.push(sum);
        console.log('push', set);
        numAr = String(sum).split('').map(v => Number(v));
      }
   
  }
};

console.log(isHappy(78));