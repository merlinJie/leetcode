/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 *
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (44.24%)
 * Likes:    97
 * Dislikes: 0
 * Total Accepted:    11.1K
 * Total Submissions: 25.2K
 * Testcase Example:  '[1,null,2,2]'
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 * 假定 BST 有如下定义：
 * 
 * 
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 
 * 
 * 例如：
 * 给定 BST [1,null,2,2],
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 返回[2].
 * 
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
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
    int max = 0;
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        findModes(root,map);
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> item : map.entrySet()) {
            if(item.getValue() == max) {
                list.add(item.getKey());
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
       return res;
    }

    public void findModes(TreeNode root, Map<Integer,Integer> list) {
        if(root == null) return;
        if(list.get(root.val) == null) {
            list.put(root.val, 1);
        } else {
            list.put(root.val, list.get(root.val) + 1);
        }
        max = Math.max(list.get(root.val), max);
        findModes(root.left, list);
        findModes(root.right, list);
    }
}
// @lc code=end

