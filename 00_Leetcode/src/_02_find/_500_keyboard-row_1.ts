function findWords(words: string[]): string[] {
  const lineOne = 'qwertyuiop';
  const lineTwo = 'asdfghjkl';
  const lineThree = 'zxcvbnm';
  const mapTanKo = new Map<string, number>();
  for (let i = 0; i < lineOne.length; i++) {
    mapTanKo.set(lineOne[i], 1);
    mapTanKo.set(lineOne[i].toUpperCase(), 1);
  }
  for (let i = 0; i < lineTwo.length; i++) {
    mapTanKo.set(lineTwo[i], 2);
    mapTanKo.set(lineTwo[i].toUpperCase(), 2);
  }
  for (let i = 0; i < lineThree.length; i++) {
    mapTanKo.set(lineThree[i], 3);
    mapTanKo.set(lineThree[i].toUpperCase(), 3);
  }
  return words.filter(word => {
    if (word.length === 1) {
      return true;
    }
    const first = mapTanKo.get(word[0]);
    for (let i = 1; i < word.length; i++) {
      if(mapTanKo.get(word[i]) !== first) {
        return false;
      }
    }
    return true;
  })
};