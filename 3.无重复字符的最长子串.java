import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        } 
        char[] cc = s.toCharArray();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; i < cc.length; i++) {
            if(map.containsKey(cc[i])) {
                j = Math.max(map.get(cc[i]), j);
            }
            max = Math.max(max, i - j + 1);
            map.put(cc[i], i + 1);
        }
        return max;
    }
}
// @lc code=end

