/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 *
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/description/
 *
 * algorithms
 * Easy (52.43%)
 * Likes:    32
 * Dislikes: 0
 * Total Accepted:    13.3K
 * Total Submissions: 25.3K
 * Testcase Example:  '4'
 *
 * 泰波那契序列 Tn 定义如下： 
 * 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 25
 * 输出：1389537
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        int[] tri = new int[40];
        tri[0] = 0;
        tri[1] = 1;
        tri[2] = 1;
        for(int i = 3;i <= n; i++) {
            tri[i] = tri[i - 1] + tri[i - 2] + tri[i - 3];
        }
        return tri[n];
    }
}
// @lc code=end

