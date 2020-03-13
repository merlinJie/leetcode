import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (60.71%)
 * Likes:    496
 * Dislikes: 0
 * Total Accepted:    130.2K
 * Total Submissions: 208.6K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        Integer maxKey = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if(map.get((i))!=null) {
                map.put(i, map.get(i) + 1);
                if(maxKey != null && map.get(i) > map.get(maxKey)) {
                    maxKey = i;
                }
            } else {
                map.put(i, 1);
                if(maxKey != null && map.get(i) > map.get(maxKey)) {
                    maxKey = i;
                } else if(maxKey == null) {
                    maxKey = i;
                }
            }
        }
       
        return maxKey;
    }
}
// @lc code=end

