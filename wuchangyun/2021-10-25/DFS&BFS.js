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
        [...queue].forEach(child =>{
            queue.shift();
            result.push(child.name);
            child.children && (queue.push(...(child.children)));
        })
    }
    return result.join(',');
}

console.log(getName(data))
console.log(getName2(data))
// console.log(...data);
