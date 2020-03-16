import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (53.89%)
 * Likes:    133
 * Dislikes: 0
 * Total Accepted:    18.8K
 * Total Submissions: 34.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 计算给定二叉树的所有左叶子之和。
 * 
 * 示例：
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 
 * 
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
    int count = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        travel(root, false);
        return count;
    }

    public void travel(TreeNode root, boolean isLeft) {
        if(root == null) return;
        if(isLeft && root.left == null && root.right == null) {
            count = count + root.val;
        }
        travel(root.left, true);
        travel(root.right, false);
    }
}
// @lc code=end

