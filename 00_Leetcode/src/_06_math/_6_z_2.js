function convert(s, numRows) {
  if (numRows < 2) return s;
  let res = new Array(numRows).fill('');
  let i = 0, flag = -1;
  for (let c of s) {
    res[i] += c;
    if (i === 0 || i === numRows - 1) {
      flag = -flag;
    }
    i += flag;
  }
  return res.reduce((a, b) => (a + b), '');
};

console.log(convert("AB", 1)) // AB

console.log(convert("LEETCODEISHIRING", 3)) // LCIRETOESIIGEDHN

console.log(convert("LEETCODEISHIRING", 4)) // LDREOEIIECIHNTSG

console.log(convert("HELLO", 2)); // Created by ChatGPT but it's not correct // HLOEL
// Output: HEO LLL


// console.log(convert("LEETCODEISHIRING", 5)) // LIEESGEDHNTOIICR
