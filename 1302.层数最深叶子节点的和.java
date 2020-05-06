/*
 * @lc app=leetcode.cn id=1302 lang=java
 *
 * [1302] 层数最深叶子节点的和
 *
 * https://leetcode-cn.com/problems/deepest-leaves-sum/description/
 *
 * algorithms
 * Medium (80.88%)
 * Likes:    14
 * Dislikes: 0
 * Total Accepted:    5.7K
 * Total Submissions: 7.1K
 * Testcase Example:  '[1,2,3,4,5,null,6,7,null,null,null,null,8]'
 *
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
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
    int maxLeval = 0;
    int maxCount = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 1);
        return maxCount;
    }

    public void dfs(TreeNode root, int leval) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(leval > maxLeval) {
                maxLeval = leval;
                maxCount = root.val;
            } else if(leval == maxLeval) {
                maxCount += root.val;
            }
        }
        dfs(root.left, leval + 1);
        dfs(root.right, leval + 1);
    }
}
// @lc code=end

