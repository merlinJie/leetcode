import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (44.81%)
 * Likes:    211
 * Dislikes: 0
 * Total Accepted:    76.7K
 * Total Submissions: 170.5K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * 
 * s = "leetcode"
 * 返回 0.
 * 
 * s = "loveleetcode",
 * 返回 2.
 * 
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 * 
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        Map<String, Integer> maps = new LinkedHashMap();
        for (char cs : s.toCharArray()) {
            if(maps.get(Character.toString(cs)) != null) {
                maps.put(Character.toString(cs), maps.get(Character.toString(cs)) + 1);
            } else {
                maps.put(Character.toString(cs), 1);
            }
        }
        String temp = null;
        for (Map.Entry<String, Integer> t : maps.entrySet()) {
            if(t.getValue() == 1 && temp == null) {
                temp = t.getKey();
            }
        }
        char[] ars = s.toCharArray();
        System.out.println(temp);
        for (int i = 0; i < ars.length; i++) {
            if(temp != null && temp.equals(Character.toString(ars[i]))) {
                return i;
            }
        } 
        return -1;
    }
}
// @lc code=end

