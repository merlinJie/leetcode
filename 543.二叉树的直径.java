import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 *
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/description/
 *
 * algorithms
 * Easy (46.45%)
 * Likes:    234
 * Dislikes: 0
 * Total Accepted:    25.7K
 * Total Submissions: 53.5K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * 
 * 示例 :
 * 给定二叉树
 * 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       2   3
 * ⁠      / \     
 * ⁠     4   5    
 * 
 * 
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * 
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
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
    int maxLe = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        travel(root);
        return maxLe;
    }

    public int travel(TreeNode root) {
        if(root == null) return 0;
        int left = travel(root.left);
        int right = travel(root.right);
        if(left + right > maxLe) {
            maxLe = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
// @lc code=end

