function complexNumberMultiply(num1, num2) {
  const num1Real = Number(num1.split("+")[0]), num1Vr = Number(num1.split("+")[1].slice(-4, -1));
  const num2Real = Number(num2.split("+")[0]), num2Vr = Number(num2.split("+")[1].slice(-4, -1));
  console.log(num1Real, num1Vr, num2Real, num2Vr)
  return `${num1Real * num2Real - num1Vr * num2Vr}+${num1Real * num2Vr + num2Real * num1Vr}i`
};

console.log(complexNumberMultiply("78+-76i"
,"-86+72i")); // "-1236+12152i"