/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
 *
 * https://leetcode-cn.com/problems/range-sum-of-bst/description/
 *
 * algorithms
 * Easy (76.68%)
 * Likes:    101
 * Dislikes: 0
 * Total Accepted:    23.3K
 * Total Submissions: 30.3K
 * Testcase Example:  '[10,5,15,3,7,null,18]\n7\n15'
 *
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 
 * 二叉搜索树保证具有唯一的值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
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
    public int rangeSumBST(TreeNode root, int L, int R) {
        rangeSum(root, L, R);
        return count;
    }

    public void rangeSum(TreeNode root, int L, int R) {
        if(root == null) return;

        rangeSum(root.left, L, R);
        if(root.val >= L && root.val <= R) {
            count += root.val;
        }
        rangeSum(root.right, L, R);
    }
}
// @lc code=end

