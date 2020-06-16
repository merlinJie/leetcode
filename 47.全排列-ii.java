/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (58.63%)
 * Likes:    316
 * Dislikes: 0
 * Total Accepted:    64.2K
 * Total Submissions: 108.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> out = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new LinkedList<Integer>());

        return out;
    }

    public void dfs(int[] nums, boolean visted[], LinkedList<Integer> temp) {
        if(temp.size() == nums.length && !out.contains(temp)) {
            out.add(new ArrayList(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visted[i]) {
                continue;
            }
            visted[i] = true;
            temp.add(nums[i]);
            dfs(nums, visted, temp);
            temp.removeLast();
            visted[i] = false;
        }
    }
}

// @lc code=end

