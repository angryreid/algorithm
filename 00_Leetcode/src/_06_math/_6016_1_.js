function cellsInRange(s) {
  let [ startCol, startRow ] = s.split(':')[0].split('');
  let [ endCol, endRow ] = s.split(':')[1].split('');
  let res = [];
  startRow = Number(startRow);
  endRow = Number(endRow);
  while (startCol <= endCol) {
    let i = startRow;
    while (i <= endRow) {
      res.push(startCol + i);
      i++;
    }
    startCol = String.fromCharCode(startCol.charCodeAt(0) + 1);
  }
  return res;
};

console.log(cellsInRange('K1:L2'))