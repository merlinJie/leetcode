import java.util.HashMap;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (67.37%)
 * Likes:    173
 * Dislikes: 0
 * Total Accepted:    28.3K
 * Total Submissions: 42K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] inorder;
    int[] postorder;
    int posIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        posIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildRoot(0, inorder.length - 1);
    }

    private TreeNode buildRoot(int left, int right) {
        if(left > right || posIndex < 0) return null;
        int rootVal = postorder[posIndex];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        posIndex -= 1;

        root.right = buildRoot(rootIndex + 1, right);
        root.left = buildRoot(left, rootIndex - 1);

        
        return root;
    }
}
// @lc code=end

