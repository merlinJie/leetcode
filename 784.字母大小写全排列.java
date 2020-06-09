/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 *
 * https://leetcode-cn.com/problems/letter-case-permutation/description/
 *
 * algorithms
 * Easy (64.11%)
 * Likes:    174
 * Dislikes: 0
 * Total Accepted:    20.5K
 * Total Submissions: 31.9K
 * Testcase Example:  '"a1b2"'
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 
 * 
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * 
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 
 * 
 * 注意：
 * 
 * 
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 * 
 * 
 */

// @lc code=start
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        char[] c = S.toCharArray();
        backtrack(c, 0);
        return result;
    }

    public void backtrack(char[] s, int i) {
        if(s.length == i) {
            result.add(new String(s));
            return;
        }
        char c = s[i];

        if(c >= 'a' && c <= 'z') {
            s[i] = (char)(s[i] - 32);
            backtrack(s, i + 1);
            s[i] = c;
        } else if(c >= 'A' && c <= 'Z') {
            s[i] = (char)(s[i] + 32);
            backtrack(s, i + 1);
            s[i] = c;
        }
        backtrack(s, i + 1);
    }
}
// @lc code=end

