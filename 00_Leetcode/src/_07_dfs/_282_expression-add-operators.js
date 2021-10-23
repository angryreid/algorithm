/**
 * @param {string} num
 * @param {number} target
 * @return {string[]}
 */
 const ops = ["-", "*", "+", ""];
 var addOperators = function(num, target) {    
     const ans = [], path = [];
 
     const dfs = (idx, sign, curv, val) => {
         let c = num.charAt(idx);
         curv = 10 * curv + (c - '0');
         if(idx == num.length - 1){
             if(target - val == sign * curv){
                 path.push(c);
                 ans.push(path.join(""));
                 path.pop();
             }
         }
         else{
             for(let i=0;i<ops.length;i++){
                 path.push(c + ops[i]);
                 if(i == 1)
                     dfs(idx+1,sign * curv, 0, val);
                 else if(i < 3)
                     dfs(idx+1,i-1, 0, val + sign * curv);
                 else if(curv > 0 || c != '0')
                     dfs(idx+1,sign,curv,val);
                 path.pop();
             }
         }
     }
 
     dfs(0, 1, 0, 0);
     return ans;
 };
 
 
 
//  作者：himymBen
//  链接：https://leetcode-cn.com/problems/expression-add-operators/solution/pythonjavajavascript-dfshui-su-by-himymb-ojgo/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。