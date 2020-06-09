/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 *
 * https://leetcode-cn.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (59.90%)
 * Likes:    234
 * Dislikes: 0
 * Total Accepted:    35.1K
 * Total Submissions: 58.4K
 * Testcase Example:  '[1,2,2]'
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: [1,2,2]
 * 输出:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */

// @lc code=start
class Solution {
    int n = 1;
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new LinkedList<Integer>(), 0);
        return out;
    }

    public void backtrack(int[] nums, LinkedList<Integer> temp, int start) {
        out.add(new ArrayList<Integer>(temp));       
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, temp, i + 1);
            temp.removeLast();
        }
    }
}
// @lc code=end

