/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 *
 * https://leetcode-cn.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (35.52%)
 * Likes:    140
 * Dislikes: 0
 * Total Accepted:    30.2K
 * Total Submissions: 83.7K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 
 * 示例1:
 * 
 * 
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 
 * 
 * 
 * 
 * 示例2:
 * 
 * 
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<String, Integer> window = new HashMap<>();
        HashMap<String, Integer> need = new HashMap<>();
        for(char c : s1.toCharArray()) {
            if (need.get(String.valueOf(c)) != null) {
                need.put(String.valueOf(c), need.get(String.valueOf(c)) + 1);
            } else {
                need.put(String.valueOf(c), 1);                
            }
            System.out.println(need.get(String.valueOf(c)) + "  ");
        }
        int left = 0;
        int right = 0;
        int valide = 0;
        while(right < s2.length()) {
            String current = String.valueOf(s2.charAt(right));
            right++;
            if (need.get(current) != null) {
                if (window.get(current) != null) {
                    window.put(current, window.get(current) + 1);
                } else {
                    window.put(current, 1);
                }
                if(window.get(current).intValue() == need.get(current).intValue()) {
                    valide++;
                }
            }

            while(right - left >= s1.length()) {
                if(valide == need.size()) {
                    return true;
                }
                String currentLeft = String.valueOf(s2.charAt(left));
                left++;
                if (need.get(currentLeft) != null) {
                    if(window.get(currentLeft).intValue() == need.get(currentLeft).intValue()) {
                        valide--;
                    }
                    if (window.get(currentLeft) != null) {
                        window.put(currentLeft, window.get(currentLeft) - 1);
                    }
                }
            }
        }

        return false;
    }
}
// @lc code=end

