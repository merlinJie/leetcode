/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 *
 * https://leetcode-cn.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (55.06%)
 * Likes:    190
 * Dislikes: 0
 * Total Accepted:    33.8K
 * Total Submissions: 59.3K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 
 * 
 * 进阶：
 * 
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        while(list1 != null) {
            stack1.push(list1.val);
            list1 = list1.next;
        }
        ListNode list2 = l2;
        while(list2 != null) {
            stack2.push(list2.val);
            list2 = list2.next;
        }
        ListNode pre = null;
        ListNode curNode = pre;
        boolean needPlus = false;
        while(!stack2.isEmpty() || !stack1.isEmpty() || (pre != null && needPlus)) {
            int cur = 0;
            cur += stack1.isEmpty() ? 0: stack1.pop();
            cur += stack2.isEmpty() ? 0: stack2.pop();

            if(pre != null && needPlus) {
               cur += 1;
            }
            if(cur >= 10) {
                needPlus = true;
            } else {
                needPlus = false;
            }
            curNode = new ListNode(cur % 10);
            curNode.next = pre;
            pre = curNode;
        }
      
        return curNode;
    }
}
// @lc code=end

