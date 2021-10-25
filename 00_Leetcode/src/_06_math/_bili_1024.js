// function test() {
//   let result = 0;
//   for (let i = 100; i<=10000; i++) {
//     if (i%2 === 0) {
//       result += i;
//     }
//   }
//   return result;
// }

// console.log(test())


function f(n) {
  if(n <= 6) return 1;
  return f(n-1) + f(n-2) + f(n-3);
}

console.log(f(10))