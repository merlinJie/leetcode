/*
 * @lc app=leetcode.cn id=1291 lang=java
 *
 * [1291] 顺次数
 *
 * https://leetcode-cn.com/problems/sequential-digits/description/
 *
 * algorithms
 * Medium (48.54%)
 * Likes:    10
 * Dislikes: 0
 * Total Accepted:    3.3K
 * Total Submissions: 6.8K
 * Testcase Example:  '100\n300'
 *
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * 
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 
 * 
 * 示例 2：
 * 
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 10 <= low <= high <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 9; i++) {
            int num = i;
            for(int j = i + 1; j <= 9; j++) {
                num = num * 10 + j;
                if(num >= low && num <= high) {
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
// @lc code=end

