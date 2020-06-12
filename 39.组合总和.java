/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (68.84%)
 * Likes:    626
 * Dislikes: 0
 * Total Accepted:    86.2K
 * Total Submissions: 125.3K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new LinkedList<Integer>());
        return out;
    }

    public void dfs(int[] candidates, int target, int start, LinkedList<Integer> temp) {
        if(target == 0) {
            out.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if(target - candidates[i] < 0) {
                break;
            }
            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, temp);
            temp.removeLast();
        }
    }
}
// @lc code=end

