// "1123"
// "0111"


function getHint(secret, guess) {
  let secretMap = new Map();
  let guessMap = new Map();

  let bulls = 0, cows = 0;
  for (let i = 0; i < secret.length; i++) {
    if (secret[i] == guess[i]) {
      bulls++;
    } else {
      const secretKey = secret[i];
      const guessKey = guess[i];
      !secretMap.has(secretKey) && secretMap.set(secretKey, 0);
      !guessMap.has(guessKey) && guessMap.set(guessKey, 0);
      secretMap.set(secretKey, secretMap.get(secretKey) + 1);
      guessMap.set(guessKey, guessMap.get(guessKey) + 1);
    }
  }
  secretMap.forEach((count, key) => {
    if (guessMap.has(key)) {
      const guessCount = guessMap.get(key);
      if (count <= guessCount) {
        cows += count;
      } else {
        cows += guessCount;
      }
    }
  })

  return `${bulls}A${cows}B`;
};

console.log(getHint('1123', '0111'));