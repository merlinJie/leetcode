/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (59.01%)
 * Likes:    187
 * Dislikes: 0
 * Total Accepted:    36.9K
 * Total Submissions: 62.6K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
    int sum;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        if(root == null) return result;
    
        List<Integer> visted = new ArrayList<>();
        checkSum(root, 0, visted);
        return result;
    }
    public void checkSum(TreeNode node, int count, List<Integer> visted) {
        if(node == null) {
            return;
        }
        count = count += node.val;
        visted.add(node.val);
        if(node.left == null && node.right == null) {
            if(sum == count) { 
                List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(visted);
                result.add(temp);
            }
        }
        checkSum(node.left, count, visted);
        checkSum(node.right, count, visted);
        visted.remove(visted.size() - 1);
    }
}
// @lc code=end

