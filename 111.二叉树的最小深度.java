import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (41.68%)
 * Likes:    223
 * Dislikes: 0
 * Total Accepted:    57.7K
 * Total Submissions: 138.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return depth(root, 0);
    }

    public int depth(TreeNode rNode, int deep) {
        if(rNode == null) return deep;
        if(rNode.left != null && rNode.right == null){
            return depth(rNode.left, deep + 1) ;
        }
        if(rNode.right != null && rNode.left == null) {
            return depth(rNode.right, deep + 1);
        }
        int left = depth(rNode.left, deep);
        int right = depth(rNode.right, deep);
        return Math.min(left, right) + 1; 
    }
}
// @lc code=end

