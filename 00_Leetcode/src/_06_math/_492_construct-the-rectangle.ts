// 1
function constructRectangle(area: number): number[] {
  let height = Math.floor(Math.sqrt(area));
  while ( area % height !== 0) {
    height--;
  }
  return [area / height, height];
};

// 2
function constructRectangle2(area: number): number[] {
  let width = area, height = 1;
  let closeWidthAndHeight: number[] = [width, height];
  while (width >= height) {
    if (area % height === 0) {
      width = area / height;
      closeWidthAndHeight = [width, height];
    }
    height += 1;
    width = Math.floor(area / height);
  }
  return closeWidthAndHeight;
};