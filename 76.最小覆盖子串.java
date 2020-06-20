/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (36.00%)
 * Likes:    598
 * Dislikes: 0
 * Total Accepted:    57.2K
 * Total Submissions: 150.8K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 
 * 说明：
 * 
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<String, Integer> window = new HashMap<>();
        Map<String, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            String cc = String.valueOf(c);
            need.put(cc, need.get(cc) == null ? 1 : need.get(cc) + 1);
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int count = 0;
        int len = Integer.MAX_VALUE;
        while(right < s.length()) {
            String cr = String.valueOf(s.charAt(right));
            right++;
            if (need.get(cr) != null) {
                window.put(cr, window.get(cr) == null ? 1 : window.get(cr) + 1);
                if (need.get(cr).intValue() == window.get(cr).intValue()) {
                    count++;
                }
            }
            while(need.size() == count) {
                if (right - left < len) {
                    start = left;
                    end = right;
                    len = end - left;
                }
                String cl = String.valueOf(s.charAt(left));
                if (need.get(cl) != null) {
                    if (need.get(cl).intValue() == window.get(cl).intValue()) {
                        count--;
                    }
                    window.put(cl, window.get(cl) == null ? 1 : window.get(cl) - 1);
                }
                left++;
            }
        }
        return s.substring(start, end);
    }
}
// @lc code=end

