/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 *
 * https://leetcode-cn.com/problems/maximum-binary-tree/description/
 *
 * algorithms
 * Medium (80.26%)
 * Likes:    127
 * Dislikes: 0
 * Total Accepted:    12.7K
 * Total Submissions: 15.8K
 * Testcase Example:  '[3,2,1,6,0,5]'
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 
 * 
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 
 * 
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 
 * 
 * 
 * 示例 ：
 * 
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * 
 * ⁠     6
 * ⁠   /   \
 * ⁠  3     5
 * ⁠   \    / 
 * ⁠    2  0   
 * ⁠      \
 * ⁠       1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定的数组的大小在 [1, 1000] 之间。
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helpConstructMax(nums, 0, nums.length - 1);
    }

    public TreeNode helpConstructMax(int[] nums, int l, int r) {
        int maxIndex = findMaxIndex(nums, l, r);
        if(-1 == maxIndex) return null;
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helpConstructMax(nums, l, maxIndex - 1);
        root.right = helpConstructMax(nums, maxIndex + 1, r);
        return root;
    }

    public int findMaxIndex(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = l; i <= r; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
// @lc code=end

