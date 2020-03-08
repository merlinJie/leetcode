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
    HashMap<Integer, Integer>  map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        return changeConin(coins, amount);
    }

    public int changeConin(int[] coins, int amount) {
        if(map.get(amount) != null)  return map.get(amount);
        if(amount == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i : coins) {
            if(amount - i < 0) continue;
            int sub = changeConin(coins, amount - i);
            if(sub == -1) continue;
            min = Math.min(min, sub + 1);
        }
        int result = min == Integer.MAX_VALUE ? -1 : min;
        if(result != -1 || map.get(amount) == null || map.get(amount) > result) {
            map.put(amount, result);
        }
        return result;
    }
}
// @lc code=end

