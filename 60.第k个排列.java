/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 *
 * https://leetcode-cn.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (48.66%)
 * Likes:    250
 * Dislikes: 0
 * Total Accepted:    35.1K
 * Total Submissions: 72.2K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 
 * 
 */

// @lc code=start
class Solution {
    List<String> out = new ArrayList<>();
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        StringBuilder solution = new StringBuilder();
        backTracking(visited,k, n, solution);
        return out.get(out.size() - 1);
    }
    
    public void backTracking(boolean[] visited, int k, int n, StringBuilder solution) {
        if(out.size() == k) return;
        if(solution.length() == n) {
            out.add(solution.toString());
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i - 1]) continue;
            solution.append(i);
            visited[i - 1] = true;
            backTracking(visited ,k, n, solution);
            visited[i - 1] = false;
            solution.deleteCharAt(solution.length() - 1);
        }
    }
}
// @lc code=end

