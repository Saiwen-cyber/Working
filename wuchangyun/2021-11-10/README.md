## 动态规划(第一天)

> 什么是
>
> [动态规划]: https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/thinkings/dynamic-programming#dong-tai-gui-hua	"动态规划"

### 01背包问题

>一个背包总容量为V，现在有N个物品，第i个 物品体积为weight[i]，价值为value[i]，现在往背包里面装东西，怎么装能使背包的内物品价值最大？

```js
	let value = [0,3,4,5,6]
    let weight = [0,2,3,4,5]
    let capacity = 8
    var backMax = function (value,weight,capacity) {
        var dp = new Array()
        for(let i = 0; i <= value.length;i++){
             dp[i] = new Array();
            for(let j = 0; j <= capacity;j++){
                dp[i][j] = 0
            }
        }
        console.log(dp)

        for(let i = 1;i <= value.length;i++){
            for(let j = 1;j <= capacity;j++){
                if(weight[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
                    // dp[i][j] = dp[i-1][j]>dp[i-1][j-weight[i]]+value[i] ? dp[i-1][j]:dp[i-1][j-weight[i]]+value[i]

                } else {
                    dp[i][j] = dp[i - 1][j]
                }
            }

        }
        return dp[value.length][capacity]
    }

    console.log(backMax(value,weight,capacity)) // 10
```

### 最长回文子串

>给你一个字符串 `s`，找到 `s` 中最长的回文子串。

```js
/**
 * @param {string} s
 * @return {string}
 */

var longestPalindrome = function (s) {
    let res = '';
    let n = s.length;
    let dp = Array.from(Array(n), () => Array(n).fill(false));
    for (let i = n - 1; i >= 0; i--) {
        for (let j = i; j < n; j++) {
            dp[i][j] = s[i] === s[j]&& (j-i<2 || dp[i+1][j-1]);
            if (dp[i][j] && j - i + 1 > res.length) {
                res = s.substring(i, j + 1);
            }
        }
    }
    return res;
}
```

