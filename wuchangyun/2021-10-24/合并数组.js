function ListNode(val) {
    this.val = val
    this.next = null
}
const l1 = new ListNode(1);
const a = new ListNode(2);
const b = new ListNode(4);
const c = new ListNode(5);
l1.next = a;
a.next =b;
b.next=c;

const l2 = new ListNode(1);
const x = new ListNode(3);
const y = new ListNode(4);
l2.next = x;
x.next =y;
let mergeTwoLists = function (l1, l2) {
    // let res = new ListNode(0)
    //
    // let p = res;
    // let [p1,p2] = [l1,l2]
    // // console.log(p1)
    // // console.log(p2)
    // while (p1&&p2){
    //     if(p1.val < p2.val){
    //         p.next = p1
    //         p1 = p1.next
    //     }else{
    //         p.next = p2
    //         p2 = p2.next
    //     }
    //     console.log("---")
    //     console.log(p)
    //     console.log("---")
    //     p = p.next
    // }
    //
    // p.next = p1 ? p1: p2
    // // console.log(res);
    // // console.log(res.next);
    // // console.log(res.next.next);
    // // console.log(res.next.next.next);
    // return res.next


    /*
    * 方法二：递归
    * */

    if(!l1 || !l2) return l1 || l2
    if(l1.val < l2.val){
        l1.next = mergeTwoLists(l1.next,l2)
        return l1
    }else{
        l2.next = mergeTwoLists(l1,l2.next)
        return l2
    }
}


let res = mergeTwoLists(l1,l2);

console.log(res);
// console.log(res.next);
// console.log(res.next.next);
// console.log(res.next.next.next);
