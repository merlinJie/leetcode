/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (77.11%)
 * Likes:    546
 * Dislikes: 0
 * Total Accepted:    82.1K
 * Total Submissions: 106.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> out = new ArrayList<>();
    int n = 0;
    public List<List<Integer>> subsets(int[] nums) {
        out.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++) {
            n = i + 1;
            backTracking(new ArrayList<Integer>(), nums, 0);
        }
        return out;
    }

    public void backTracking(List<Integer> temps, int[] nums, int first) {
        if(temps.size() == n) {
            out.add(new ArrayList<Integer>(temps));
            return;
        }

        for(int i = first; i < nums.length; i++) {
            if(temps.contains(nums[i])) {
                return;
            }
            temps.add(nums[i]);
            backTracking(temps, nums, i + 1);
            temps.remove(Integer.valueOf(nums[i]));
        }
    }
}
// @lc code=end

