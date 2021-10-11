/**
 * @param {number} num
 * @return {string}
 */
const nt = ["Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
        "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"],
      tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"],
      bmt = ["Billion","Million","Thousand"],
      BILLION = 1000000000, MILLION = 1000000, THOUSAND = 1000;
var num2str = function(num) {
    const ans = [];
    if(num >= 100){
        ans.push(nt[Math.floor(num/100)]);
        ans.push("Hundred");
        num %= 100;
    }
    if(num >= 20){
        ans.push(tens[Math.floor(num/10)]);
        num %= 10;
    }
    if(num > 0){
        ans.push(nt[num]);
    }
    return ans.join(" ");
}
var numberToWords = function(num) {
    if(num == 0)
        return nt[num];
    const res = [];
    if(num >= BILLION){
        res.push(num2str(Math.floor(num/BILLION)));
        res.push(bmt[0]);
        num %= BILLION;
    }
    if(num >= MILLION){
        res.push(num2str(Math.floor(num/MILLION)));
        res.push(bmt[1]);
        num %= MILLION;
    }
    if(num >= THOUSAND){
        res.push(num2str(Math.floor(num/THOUSAND)));
        res.push(bmt[2]);
        num %= THOUSAND;
    }
    if(num > 0)
        res.push(num2str(num));
    return res.join(" ");
};
