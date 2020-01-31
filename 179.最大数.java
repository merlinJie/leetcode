import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 *
 * https://leetcode-cn.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (34.49%)
 * Likes:    184
 * Dislikes: 0
 * Total Accepted:    16.8K
 * Total Submissions: 48.6K
 * Testcase Example:  '[10,2]'
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 
 * 示例 1:
 * 
 * 输入: [10,2]
 * 输出: 210
 * 
 * 示例 2:
 * 
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length == 0) {
            return "0";
        }
        Integer[] arrs = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arrs[i] = nums[i];
        }
    
        Arrays.sort(arrs, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                String tempA = o1 + "" + o2;
                String tempB = o2 + "" + o1;
                return tempB.compareTo(tempA);
            }
            
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arrs.length; i++) {
            sb.append(arrs[i]);
        }
        String result = sb.toString();
        return result.charAt(0) == '0' ? "0" : result;
    }

}
// @lc code=end

