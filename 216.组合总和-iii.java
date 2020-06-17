/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (71.01%)
 * Likes:    123
 * Dislikes: 0
 * Total Accepted:    22.4K
 * Total Submissions: 31.4K
 * Testcase Example:  '3\n7'
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 
 * 说明：
 * 
 * 
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, new LinkedList<Integer>());
        return out;
    }

    public void dfs(int k, int n, int start, LinkedList<Integer> temp) {
        if(k == temp.size() && n == 0) {
            out.add(new ArrayList(temp));
            return;
        }

        for(int i = start; i <= 9; i++) {
            temp.add(i);
            dfs(k, n - i, i + 1, temp);
            temp.removeLast();
        }
    }
}
// @lc code=end

