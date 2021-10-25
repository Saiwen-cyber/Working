## 前端算法

> 广度/深度优先算法

算法无非是时间与空间的转换 时间换空间 空间换时间

1.深度优先不需要记住所有的节点、所以占用空间小；而广度优先需要记录所有节点占用空间大

2.深度优先有回溯的操作、所以相对而言时间会长一点

数据存储选择

深度优先采用的是堆栈的形式：先进后出

广度优先采用的是队列的形式：先进先出

```js
const data = [
    {
        name: 'a',
        children: [
            { name: 'b', children: [{ name: 'e' }] },
            { name: 'c', children: [{ name: 'f' }] },
            { name: 'd', children: [{ name: 'g' }] },
        ],
    },
    {
        name: 'a2',
        children: [
            { name: 'b2', children: [{ name: 'e2' }] },
            { name: 'c2', children: [{ name: 'f2' }] },
            { name: 'd2', children: [{ name: 'g2' }] },
        ],
    }
]

// 深度遍历, 使用递归
function getName(data) {
    const result = [];
    data.forEach(item =>{
        const map = data =>{
            result.push(data.name);
            // 一直向下递归 知道没有子节点 返回
            data.children && data.children.forEach(child => map(child));
        }
        map(item);
    })
    return result.join(',');
}

// 广度遍历, 使用队列
function getName2(data) {
    const result = [];
    const queue = data;
    while(queue.length){
        // ...展开的目的为了重置forEach
        [...queue].forEach(child =>{
            queue.shift();
            result.push(child.name);
            // 将节点的子节点加入队列
            child.children && (queue.push(...(child.children)));
        })
    }
    return result.join(',');
}

console.log(getName(data)) // a,b,e,c,f,d,g,a2,b2,e2,c2,f2,d2,g2
console.log(getName2(data))// a,a2,b,c,d,b2,c2,d2,e,f,g,e2,f2,g2
// console.log(...data);
```

