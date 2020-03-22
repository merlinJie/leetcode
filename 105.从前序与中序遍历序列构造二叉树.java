import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (64.41%)
 * Likes:    375
 * Dislikes: 0
 * Total Accepted:    51.4K
 * Total Submissions: 79.6K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        if(preorder.length == 0 || inorder.length == 0) return null;
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildRoot(0, inorder.length - 1);
    }
    
    public TreeNode buildRoot(int left, int right) {
        if(left > right) return null;
        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);

        preIndex += 1;
        root.left = buildRoot(left, mid - 1);
        root.right = buildRoot(mid + 1, right);
        return root;
    }
}
// @lc code=end

