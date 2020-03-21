import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 *
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (69.55%)
 * Likes:    344
 * Dislikes: 0
 * Total Accepted:    53.7K
 * Total Submissions: 77.2K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定有序数组: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
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
 * 思路分析：
 * 首先数组是有序的，遍历二叉树能生成有序的数组只有中序遍历，则先考虑中序
 * 
 * 要从素组生成二叉树，并且按照中序遍历，则需要取数组的中间值，递归操作可以按最小的子树考虑，
 * 每一次都需要取中间值作为root 节点
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if(left > right) return null;

        TreeNode node = new TreeNode(nums[mid]);
        TreeNode leftNode = buildBST(nums, left, mid - 1);
        TreeNode rightNode = buildBST(nums, mid + 1, right);

        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
// @lc code=end

