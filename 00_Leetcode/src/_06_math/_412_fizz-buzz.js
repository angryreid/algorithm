/**
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function(n) {
    const fizz = "Fizz";
    const buzz = "Buzz";
    const fb = "FizzBuzz";
    let i = 1;
    let result = [];
    while(i <= n) {
        if (i % 15 === 0) {
            result.push(fb);
        } else if (i % 5 === 0) {
            result.push(buzz);
        } else if(i % 3 === 0) {
            result.push(fizz);
        } else {
            result.push(String(i));
        }
        i++;
    }
    return result;
};
