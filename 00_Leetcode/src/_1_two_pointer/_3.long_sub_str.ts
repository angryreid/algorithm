function lengthOfLongestSubstring(s: string): number {
  let l = 0,
      r = 0,
      max = 0,
      freq = new Map<string, number>();
  while(r < s.length) {
    if(!freq.has(s[r]))
      freq.set(s[r], 0);
    if(freq.get(s[r]) === 0) {
      freq.set(s[r], 1);
      r++;
    } else {
      freq.set(s[r], freq.get(s[r]) - 1);
      l++;
    }
    max = Math.max(max, r - l);
  }
  return max;
};