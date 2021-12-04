function canConstruct(ransomNote: string, magazine: string): boolean {
  if (ransomNote.length > magazine.length) return false;

  const mapCnt = new Map<string, number>();
  for (let i = 0; i < magazine.length; i++) {
    const s = magazine[i];
    if (!mapCnt.has(s)) {
      mapCnt.set(s, 1);
    } else {
      mapCnt.set(s, mapCnt.get(s) + 1);
    }
  }

  for (let i = 0; i < ransomNote.length; i++) {
    const s = ransomNote[i];
    if (mapCnt.has(s) && mapCnt.get(s) !== 0) {
      mapCnt.set(s, mapCnt.get(s) - 1);
    } else {
      return false;
    }
  }
  return true;
};