/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
 *
 * https://leetcode-cn.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (62.11%)
 * Likes:    53
 * Dislikes: 0
 * Total Accepted:    4.1K
 * Total Submissions: 6.6K
 * Testcase Example:  '[5,2,-3]'
 *
 * 
 * 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
 * 
 * 
 * 
 * 示例 1
 * 输入:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 * 
 * 
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 * 
 * 示例 2
 * 输入:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 * 
 * 
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 * 
 * 
 * 
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
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
    int max = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        findMax(root);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        int res[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int findMax(TreeNode root) {
        if(root == null) return 0;

        int left = findMax(root.left);
        int right = findMax(root.right);
        int sum = root.val + left + right;
        if(map.get(sum) == null) {
            map.put(sum, 1);
        } else {
            map.put(sum, map.get(sum) + 1);
        }
        max = Math.max(map.get(sum), max);
        return sum;
    }
}
// @lc code=end

