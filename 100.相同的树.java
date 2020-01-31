import java.util.ArrayList;
import java.util.function.Predicate;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 *
 * https://leetcode-cn.com/problems/same-tree/description/
 *
 * algorithms
 * Easy (56.05%)
 * Likes:    298
 * Dislikes: 0
 * Total Accepted:    57.6K
 * Total Submissions: 102.8K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * 示例 1:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * 
 * ⁠       [1,2,3],   [1,2,3]
 * 
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:      1          1
 * ⁠         /           \
 * ⁠        2             2
 * 
 * ⁠       [1,2],     [1,null,2]
 * 
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * 
 * ⁠       [1,2,1],   [1,1,2]
 * 
 * 输出: false
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
 * 个人垃圾解法 用作反省
 * class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        ArrayList<Integer> firstArray = new ArrayList<Integer>();
        ArrayList<Integer> secondArray = new ArrayList<Integer>();
        fillArrayList(p, firstArray);
        fillArrayList(q, secondArray);

        if(firstArray.size() != secondArray.size()) {
            System.out.println(firstArray.size() + "   "+ secondArray.size());
            return false;
        }
        Boolean result = true;
        for (int i = 0; i < firstArray.size(); i++) {
            if(secondArray.get(i) == null && firstArray.get(i) == null) {
                continue;
            }
            if(secondArray.get(i) == null || firstArray.get(i) == null) {
                return false;
            }
            if(firstArray.get(i).compareTo(secondArray.get(i)) != 0) {
                System.out.println(firstArray.get(i) + "  != " + secondArray.get(i));
                return false;
            } 
        }
        return result;
    }

    public void fillArrayList(TreeNode root, ArrayList array ) {
        if(root == null) {
            array.add(null);
            return;
        } 
        array.add(root.val);
        fillArrayList(root.left, array);
        fillArrayList(root.right, array);
    }
}
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        return p.val  == q.val && isSameTree(p.left, q.left) &&
        isSameTree(p.right, q.right);
    }

}
// @lc code=end

