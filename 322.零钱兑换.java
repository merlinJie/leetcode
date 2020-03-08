import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (37.07%)
 * Likes:    438
 * Dislikes: 0
 * Total Accepted:    52.9K
 * Total Submissions: 139.2K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3 
 * 解释: 11 = 5 + 5 + 1
 * 
 * 示例 2:
 * 
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * 
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length  == 0) return -1;
        int max = amount + 1;
        int[] mem = new int[max];
        Arrays.fill(mem, max);
        mem[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if(c <= i) {
                    mem[i] = Math.min(mem[i], mem[i - c] + 1);
                }
            }
        }
        return mem[amount] > amount ? -1: mem[amount];
    }
}
// @lc code=end

