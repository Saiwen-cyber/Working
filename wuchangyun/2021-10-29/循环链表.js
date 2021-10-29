
/**
 * leetcode: 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    let p = head,q=head;
    while(q&&q.next){

        p = p.next;
        q = q.next.next;
        if(q==p){
            return true;
        }
    }
    return false
};
