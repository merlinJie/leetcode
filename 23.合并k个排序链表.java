import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (47.86%)
 * Likes:    413
 * Dislikes: 0
 * Total Accepted:    60.4K
 * Total Submissions: 125.7K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 0) {
            return null;
        } 
        if(lists.length ==1) {
            return lists[0];
        }
        ArrayList<Integer> array = new ArrayList<>();
        ListNode pre = null;
        ListNode rest = null;
        for (ListNode listNode : lists) {
            while(listNode != null) {
                array.add(listNode.val);
                listNode = listNode.next;
            }
        }
        Collections.sort(array);
        for (int i = 0; i < array.size(); i++) {
            ListNode temp  = new ListNode(array.get(i).intValue());
            if(pre == null) {
                pre = temp;
                rest = pre;
            } else {
            pre.next = temp;
            pre = pre.next;
            }
        }
        return rest;
    }
}
// @lc code=end

