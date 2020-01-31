/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */

// @lc code=start
/**[1,2]\n2
 * [1]
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode pre = null;
        int length = 0;
        while(cur != null) {
            cur = cur.next;
            length ++;
        }
        cur = head;
        int index =  length - n;
        int i = 0;
        ListNode sss = null;
        while(cur != null) {
            if(index == 0) {
                pre = cur.next;
                sss = pre;
                break;
            } else if(index == i){
                pre.next = pre.next.next;
            }
            pre = cur;
            cur = cur.next;
            if(i == 0) {
                sss = pre;
            }
            i ++;
        }
        return sss;
    }
}
// @lc code=end

