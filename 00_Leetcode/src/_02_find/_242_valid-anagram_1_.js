/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;
  const map = new Map();
  const len = s.length;
  for (let i = 0; i < len; i++) {
      if (s[i] === t[i]) continue;
      map.set(s[i], map.has(s[i]) ? map.get(s[i]) + 1 : 1);
      map.set(t[i], map.has(t[i]) ? map.get(t[i]) - 1 : -1);
  }

  for (let [key, value] of map) {
      if (value !== 0) return false;
  }
  return true;

};


var isAnagram2 = function (s, t) {
  if (s.length !== t.length) {
      return false;
  }

  var count = new Array(26).fill(0);

  for (var i = 0; i < s.length; i++) {
      count[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
      count[t.charCodeAt(i) - 'a'.charCodeAt(0)]--;
  }

  for (var j = 0; j < count.length; j++) {
      if (count[j] !== 0) {
          return false;
      }
  }

  return true;
};

var isAnagram3 = function(s, t) {
  if (s.length !== t.length) return false;
  return s.split('').sort().join('') === t.split('').sort().join('');
};

