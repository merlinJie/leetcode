/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (46.69%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    44.8K
 * Total Submissions: 95.7K
 * Testcase Example:  '"25525511135"'
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 */

// @lc code=start
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, new ArrayList<String>());
        return result;
    }

    public void dfs(String s, int start, List<String> res) {
        if(res.size() == 4) {
            if(start == s.length()) {
                result.add(String.join(".", res));
            }
            return;
        }

        for(int i = 1; i <= 3; i++) {
            if(i + start > s.length()) break;
            String fragment = s.substring(start, start + i);
            if(fragment.startsWith("0") && fragment.length() > 1 || (i == 3 && Integer.parseInt(fragment) > 255)) {
                continue;
            }

            res.add(fragment);
            dfs(s, start + i, res);
            res.remove(res.size() - 1);
        }
    }
}
// @lc code=end

