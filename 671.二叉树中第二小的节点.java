/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
 *
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/description/
 *
 * algorithms
 * Easy (46.16%)
 * Likes:    71
 * Dislikes: 0
 * Total Accepted:    10.2K
 * Total Submissions: 22K
 * Testcase Example:  '[2,2,5,null,null,5,7]'
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或
 * 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 * 
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * ⁠   2
 * ⁠  / \
 * ⁠ 2   5
 * ⁠    / \
 * ⁠   5   7
 * 
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * ⁠   2
 * ⁠  / \
 * ⁠ 2   2
 * 
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
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
    int result = -1;
    int min = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        min = root.val;
        findMin(root);
        return result;
    }

    public void findMin(TreeNode root) {
        if(root == null) return;
        if(result == -1 && root.val > min) {
            result = root.val;
            return;
        } else if(root.val < result && root.val > min) {
            result = root.val;
            return;
        }
        findMin(root.left);
        findMin(root.right);
    }
}
// @lc code=end

