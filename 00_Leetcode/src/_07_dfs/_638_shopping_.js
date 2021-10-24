/**
 * @param {number[]} price
 * @param {number[][]} special
 * @param {number[]} needs
 * @return {number}
 */
 var shoppingOffers = function(price, special, needs) {
  const cache = new Map();

  const dfs = (remain) => {
      let ans = 0;
      for(let i=0;i<remain.length;i++)
          ans += price[i] * remain[i];
      if(ans != 0){
          const key = remain.join("#");
          if(cache.has(key))
              ans = cache.get(key);
          else{
              for(const sp of special){
                  let check = true;
                  for(let i=0;i<remain.length;i++)
                      if(sp[i] > remain[i]){
                          check = false;
                          break;
                      }
                  if(check){
                      const next = [];
                      for(let i=0;i<remain.length;i++)
                          next.push(remain[i] - sp[i]);
                      ans = Math.min(ans, dfs(next) + sp[sp.length-1]);
                  }
              }
              cache.set(key, ans);
          }
      }
      return ans;
  }

  return dfs(needs);
};

// 作者：himymBen
// 链接：https://leetcode-cn.com/problems/shopping-offers/solution/pythonjavajavascript-dfs-by-himymben-13j3/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。