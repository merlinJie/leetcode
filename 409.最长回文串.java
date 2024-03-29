/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 *
 * https://leetcode-cn.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (52.12%)
 * Likes:    146
 * Dislikes: 0
 * Total Accepted:    40.2K
 * Total Submissions: 73.5K
 * Testcase Example:  '"abccccdd"'
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 
 * 示例 1: 
 * 
 * 
 * 输入:
 * "abccccdd"
 * 
 * 输出:
 * 7
 * 
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        if(s == null) return 0;
        int count = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            String st = String.valueOf(s.charAt(i));
            if(set.contains(st)) {
                set.remove(st);
                count = count + 2;
            } else {
                 set.add(st);
            }
        }
        if(set.size() > 0) {
            count = count + 1;
        }
        return count;
    }
}
// @lc code=end

