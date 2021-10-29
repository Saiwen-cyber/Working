
/*
* 定义链表
* */
 function ListNode(val) {
     this.val = val;
     this.next = null;
 }
 // 直接创建链表
let head = new ListNode(1);
let _2 = new ListNode(2);
let _3 = new ListNode(3);
let _4 = new ListNode(4);
let _5 = new ListNode(5);
head.next = _2;
_2.next = _3;
_3.next = _4;
_4.next = _5;


// 循环创建链表
var list = new ListNode(1);
var p = list;
for( let i = 2;i<=5;i++){
    let node = new ListNode(i);
    p.next = node;
    p=node;
}

 console.log(list)

/**
 * leetcode: 链表转置
 * @param {ListNode} head
 * @return {ListNode}
 */


// 递归反指向法
var reverseList_1 = function(head) {
    let res =new ListNode(null);
 const relist = (head,res) =>{
     if(head == null)
     {
         return res;
     }
     let node = relist(head.next,head);
     head.next = res;
     console.log(node)
     return node;
 }
 return relist(head,null);
 };

// 迭代
var reverseList_2 = function (head) {
    let pre = null,curr = head;
    while(curr){
        let next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
    }
}
 // console.log(reverseList(list));
