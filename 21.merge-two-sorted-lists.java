/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = null;
        ListNode pre = null;
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        if(l1.val > l2.val) {
            curr = l2;
            l2 = l2.next;  
        } else {
            curr = l1;
            l1 = l1.next;

        }
        pre = curr;
        while(l1 != null  && l2 !=  null) {

            if(l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        while(l1 != null ) {
            pre.next = l1;
            pre = pre.next;
            l1 = l1.next;
        }

        while(l2 != null ) {
            pre.next = l2;
            pre = pre.next;
            l2 = l2.next;
        }
        return curr;
    }
}
// @lc code=end

