/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
 *
 * https://leetcode-cn.com/problems/univalued-binary-tree/description/
 *
 * algorithms
 * Easy (67.18%)
 * Likes:    45
 * Dislikes: 0
 * Total Accepted:    14K
 * Total Submissions: 20.8K
 * Testcase Example:  '[1,1,1,1,1,null,1]'
 *
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[2,2,2,5,2]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
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
    boolean result = true;
    int temp;
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return false;
        temp = root.val;
        helpValide(root);
        return result;
    }

    public void helpValide(TreeNode root) {
        if(root == null) return;
        if(root.val != temp) {
            result = false;
            return;
        }

        helpValide(root.left);
        helpValide(root.right);
    }
}
// @lc code=end

