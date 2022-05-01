function digArtifacts(n, artifacts, dig) {
  let res = 0, digList = dig.map(g => `${g[0]}-${g[1]}`);

  for (let i = 0; i < artifacts.length; i++) {
    const [x1, y1, x2, y2] = artifacts[i];
    let d = [];
    for (let j = x1; j <= x2; j++) {
      for (let k = y1; k <= y2; k++) {
        d.push(`${j}-${k}`);
      }
    }
    const allDigged = d.every(g => digList.indexOf(g) !== -1);
    if (allDigged) {
      digList = digList.filter(g => digList.indexOf(g) !== -1);
      res++;
    }
  }
  return res;
};

function digArtifacts2(n, artifacts, dig) {
  let res = 0, mapDig = new Map();
  
  dig.forEach(g => {
    mapDig.set(`${g[0]}-${g[1]}`, true);
  });
  for (let i = 0; i < artifacts.length; i++) {
    const [x1, y1, x2, y2] = artifacts[i];
    let d = [];
    for (let j = x1; j <= x2; j++) {
      for (let k = y1; k <= y2; k++) {
        d.push(`${j}-${k}`);
      }
    }
    const allDigged = d.every(g => mapDig.get(g));
    if (allDigged) {
      res++;
    }
  }
  return res;
};
// console.log(digArtifacts(2, [[0,0,0,0],[0,1,1,1]], [[0,0],[0,1]]));
// console.log(digArtifacts(2, [[0,0,0,0],[0,1,1,1]], [[0,0],[0,1], [1,1]]));
