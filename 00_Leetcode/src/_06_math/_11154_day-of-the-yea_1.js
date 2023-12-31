function dayOfYear(date) {
  // 在JavaScript中，我们可以使用内置的Date对象和getFullYear，getMonth，getDate方法来实现这个功能。首先，我们将输入的字符串转换为Date对象。然后，我们创建一个新的Date对象，表示当年的第一天。最后，我们计算这两个日期之间的差值，然后将其转换为天数。
  let inputDate = new Date(date);
  let startOfYear = new Date(inputDate.getFullYear(), 0, 1);
  let differenceInMilliseconds = inputDate - startOfYear;
  let differenceInDays = differenceInMilliseconds / (1000 * 60 * 60 * 24);
  return Math.floor(differenceInDays) + 1;
}