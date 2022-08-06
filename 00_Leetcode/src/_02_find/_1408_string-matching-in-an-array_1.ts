// https://leetcode.cn/problems/string-matching-in-an-array/

function stringMatching(words: string[]): string[] {
  let set = new Set<string>();
  for (let i = 0; i < words.length; i++) {
      for (let j = i - 1; j >= 0; j--) {
          if(words[j].includes(words[i])) {
              set.add(words[i]);
          }
      }
      for (let k = i + 1; k < words.length; k++) {
          if(words[k].includes(words[i])) {
              set.add(words[i]);
          }
      }
  }
  return Array.from(set);
};