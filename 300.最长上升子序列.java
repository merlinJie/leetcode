import jdk.nashorn.internal.ir.ReturnNode;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (44.20%)
 * Likes:    532
 * Dislikes: 0
 * Total Accepted:    68.3K
 * Total Submissions: 155.8K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 * 示例:
 * 
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4 
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 
 * 说明:
 * 
 * 
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 * 
 * 
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * 
 */

// @lc code=start
class Solution {
    int[] dp;
    int max = 0;
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        dp = new int[nums.length];
        dp[0] = 1;
        max = dp[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    temp = Math.max(dp[j], temp);
                }
            }
            dp[i] = temp + 1;
            max = Math.max(dp[i], max);   
        }
        return max;
    }
}
// @lc code=end

