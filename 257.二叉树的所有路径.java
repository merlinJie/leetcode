/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (63.32%)
 * Likes:    241
 * Dislikes: 0
 * Total Accepted:    32.2K
 * Total Submissions: 50.8K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
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
    String preTag = "->";
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        getString(root, "");
        return list;
    }

    public void getString(TreeNode root, String val) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            val = val + root.val;
            list.add(val);
        }
        val = val + root.val + preTag;
        getString(root.left, val);
        getString(root.right, val);
    }
}
// @lc code=end

