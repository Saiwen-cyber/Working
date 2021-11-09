## 二分查找

>给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
>
>由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
>
>注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5
>

*** 二分注意边界条件***

```js
/*
* 方法一 ： 自己想的
* */
var nums = 1
function fn1(nums) {
    let left = 0;
    let right = nums;

    if(nums === 1)  return 1

    while (left <= right) {
        let mid = left + ((right - left) >>> 1)
        console.log(mid,left,right)
        if (mid * mid === nums) {
            return mid
        }else if(mid * mid < nums){
            left = mid
        }else{
            right = mid
        }

        if(left + 1 === right || left === right){
            return left
        }
    }


}


/*
* 看题解后的感悟
* */

function fn2( nums ) {
    let left = 0
    let right = nums
    let mid
    let ans = 0

    while(left<=right){
        mid = left+ ((right-left)>>>1)
        console.log(mid)
        if(mid * mid <= nums){
            ans = mid
            left = mid + 1
        }else{
            right = mid - 1
        }
    }
        return ans
}

console.log(fn1(nums))

```

