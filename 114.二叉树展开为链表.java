import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 *
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (67.85%)
 * Likes:    283
 * Dislikes: 0
 * Total Accepted:    30.5K
 * Total Submissions: 45K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * 给定一个二叉树，原地将它展开为链表。
 * 
 * 例如，给定二叉树
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 将其展开为：
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root == null) return;
        recursion(root);
        if(list.size() < 2) return;
        root.left = null;
        TreeNode cur = list.get(1);
        cur.left = null;
        root.right = cur;
        for (int i = 2; i < list.size(); i++) {
            cur.right = list.get(i);
            cur.left = null;
            cur = cur.right;
        }
    }

    public void recursion(TreeNode root) { 
        if(root == null) return;
        list.add(root);
        recursion(root.left);
        recursion(root.right);
    }
}
// @lc code=end


