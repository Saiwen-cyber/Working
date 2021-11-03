## 今日算法

数组中最大的第K个数

>给定整数数组 `nums` 和整数 `k`，请返回数组中第 `**k**` 个最大的元素。
>
>请注意，你需要找的是数组排序后的第 `k` 个最大的元素，而不是第 `k` 个不同的元素

```js
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

var findKthLargest = function(nums,k){
    let arraySort = nums.sort((a,b) => b - a)
    return arraySort[k-1];
}
```

具有给定数值的最小字符串

>小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
>
>字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
>
>给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
>
>注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
>
>x 是 y 的一个前缀；
>如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。

```js
/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */

var getSmallestString = function(n, k) {
    let sur = Math.floor(k/26);
    let rem = k % 26;
    while(rem < n-sur){
        rem += 26;
        sur -= 1;
    }

    let res = [];
    for(let i = n-1;i>=0;i--){
        if(sur>0){
            res[i] = 'z';
            sur--;
        }else if(sur === 0){
            res[i] = String.fromCharCode(96+rem-i);
            sur--;
        }
        else res[i] = 'a'
    }
    return res.join('');
};
```

