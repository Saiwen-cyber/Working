## this的指向

> this的指向：this永远指向最后调用它的那个对象

```js
// example
var name = "windowsName"
function a(){
    var name = "cherry"
    innerFunction()
    function innerFunction() {
        console.log(this.name) // windowsName
}
}
fn()
```

这个涉及到js中函数的调用规则，js中`引用数据类型`包括函数存储在堆内存中，`原始数据类型`存储在栈内存中d当调用函数时是直接从堆内存中调用，所有的函数在定义的时候都放在堆内存中。就算像下面这样

```js
var a = {
	name : 'xxx',
	fn: function(){
		console.log('this.name')
	}
}
```

在对象中定义的fn也是放在堆内存中的，所以如果按照a.fn()去调用这个方法，是输出`xxx`，因为这时的this是指向的a这个对象。但是如果我

```js
var b = a.fn
b()
```

这样去调用，就相当于直接在调用一个函数，这时this的指向在非严格模式下(`在浏览器中去运行这些脚本代码`)的就是Windows，当然Windows对象下没有name这个属性，所以会报错。

```js
var name = "windowsName"

var a = {
	name : 'xxx',
	fn: function(){
		console.log('this.name')
	}
}
a.fn() // xxx
var b = a.fn
b() // windowsName
```

当然严格模式下就直接undefined了。

到这儿我们就可以发现整个this的问题就是指向的问题，到底this该指向哪儿，到底该输出什么的问题，总之就一句话，**this的指向永远是最后调用它的那个对象**

## 怎么改变this的指向

> 箭头函数
>
> 在函数内部使用 _this = this
>
> 使用apply、call、bind
>
> new实例化一个对象

### 箭头函数

**箭头函数的 this 始终指向函数定义时的 this，而非执行时**

> 箭头函数中没有 this 绑定，必须通过查找作用域链来决定其值，如果箭头函数被非箭头函数包含，则 this 绑定的是最近一层非箭头函数的 this，否则，this 为 undefined

