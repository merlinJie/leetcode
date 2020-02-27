import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (65.39%)
 * Likes:    235
 * Dislikes: 0
 * Total Accepted:    56.2K
 * Total Submissions: 85.9K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1], 
 * ⁠   [1,1], all[i-1]
 * ⁠  [1,2,1],  3-2 [1-1]
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> all = new ArrayList<>();
        if(numRows == 0) return all;
        if(numRows == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(numRows);
            all.add(temp);
            return all;
        } 
        for (int i = 1; i < numRows + 1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(i == 1 || i == 2 || j == 0 || j == i-1) {
                    row.add(1);
                } else {
                    row.add(all.get(i - 2).get(j - 1) + all.get(i - 2).get(j));
                }
            }
            all.add(row);
        }
        return all;
    }
}
// @lc code=end

