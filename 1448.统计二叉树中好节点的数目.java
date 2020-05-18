/*
 * @lc app=leetcode.cn id=1448 lang=java
 *
 * [1448] 统计二叉树中好节点的数目
 *
 * https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree/description/
 *
 * algorithms
 * Medium (68.43%)
 * Likes:    1
 * Dislikes: 0
 * Total Accepted:    1.7K
 * Total Submissions: 2.5K
 * Testcase Example:  '[3,1,4,3,null,1,5]'
 *
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * 
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：root = [3,1,4,3,null,1,5]
 * 输出：4
 * 解释：图中蓝色节点为好节点。
 * 根节点 (3) 永远是个好节点。
 * 节点 4 -> (3,4) 是路径中的最大值。
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：root = [3,3,null,4,2]
 * 输出：3
 * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
 * 
 * 示例 3：
 * 
 * 输入：root = [1]
 * 输出：1
 * 解释：根节点是好节点。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 二叉树中节点数目范围是 [1, 10^5] 。
 * 每个节点权值的范围是 [-10^4, 10^4] 。
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
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        helpHandelGoodNodes(root, Integer.MIN_VALUE);
        return count;        
    }

    public void helpHandelGoodNodes(TreeNode root,int max) {
        if(root == null) return;
        max = Math.max(root.val, max);
        if(max == root.val) count+=1;
        helpHandelGoodNodes(root.left, max);
        helpHandelGoodNodes(root.right, max);
    }
}
// @lc code=end

