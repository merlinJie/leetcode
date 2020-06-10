/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (73.63%)
 * Likes:    283
 * Dislikes: 0
 * Total Accepted:    54.2K
 * Total Submissions: 73.5K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1, new LinkedList<Integer>());
        return out;
    }

    public void backTrack(int n, int k, int start, LinkedList<Integer> temp) {
        if(temp.size() == k) {
            out.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i <= n; i++) {
            temp.add(i);
            backTrack(n, k , i+1, temp);
            temp.removeLast();
        }
    }
}
// @lc code=end

