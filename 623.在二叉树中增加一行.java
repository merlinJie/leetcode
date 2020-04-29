/*
 * @lc app=leetcode.cn id=623 lang=java
 *
 * [623] 在二叉树中增加一行
 *
 * https://leetcode-cn.com/problems/add-one-row-to-tree/description/
 *
 * algorithms
 * Medium (50.28%)
 * Likes:    47
 * Dislikes: 0
 * Total Accepted:    3.3K
 * Total Submissions: 6.5K
 * Testcase Example:  '[4,2,6,3,1,5]\n1\n2'
 *
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * 
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * 
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * 
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * 二叉树如下所示:
 * ⁠      4
 * ⁠    /   \
 * ⁠   2     6
 * ⁠  / \   / 
 * ⁠ 3   1 5   
 * 
 * v = 1
 * 
 * d = 2
 * 
 * 输出: 
 * ⁠      4
 * ⁠     / \
 * ⁠    1   1
 * ⁠   /     \
 * ⁠  2       6
 * ⁠ / \     / 
 * ⁠3   1   5   
 * 
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * 二叉树如下所示:
 * ⁠     4
 * ⁠    /   
 * ⁠   2    
 * ⁠  / \   
 * ⁠ 3   1    
 * 
 * v = 1
 * 
 * d = 3
 * 
 * 输出: 
 * ⁠     4
 * ⁠    /   
 * ⁠   2
 * ⁠  / \    
 * ⁠ 1   1
 * ⁠/     \  
 * 3       1
 * 
 * 
 * 注意:
 * 
 * 
 * 输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
 * 输入的二叉树至少有一个节点。
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode result = root;
        int h = 1;
        queue.add(root);
        if(d -1 == 0) {
            TreeNode nNode = new TreeNode(v);
            nNode.left = root;
            nNode.right = null;
            return nNode;
        }
        boolean already = false;
        while(!queue.isEmpty() && !already) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(d - 1 == h) {
                    TreeNode nNode = new TreeNode(v);
                    nNode.left = cur.left;
                    nNode.right = null;
                    cur.left = nNode;
                    TreeNode nrNode = new TreeNode(v);
                    nrNode.right = cur.right;
                    nrNode.left = null;
                    cur.right = nrNode;
                    already = true;
                }
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            h += 1;            
        }

        return root;
    }
}
// @lc code=end

