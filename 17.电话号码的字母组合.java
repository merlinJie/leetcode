/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (53.50%)
 * Likes:    724
 * Dislikes: 0
 * Total Accepted:    115.1K
 * Total Submissions: 214.8K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
class Solution {
    Map<String, String> phone = new HashMap<String, String>() {{
       put("2", "abc");
       put("3", "def");
       put("4", "ghi");
       put("5", "jkl");
       put("6", "mno");
       put("7", "pqrs");
       put("8", "tuv");
       put("9", "wxyz");
   }};
   List<String> result = new ArrayList<String>();
   public List<String> letterCombinations(String digits) {
       if(digits.length() == 0) return result;
       backtrack(digits.split(""), new LinkedList<String>(), 0);
       return result;
   }

   public void backtrack(String[] sts, LinkedList<String> list, int index) {
       if(sts.length == list.size()) {
           result.add(String.join("", list));
           return;
       }
       String[] letters = phone.get(sts[index]).split("");
       for(int i = 0; i < letters.length; i++) {
           
           list.add(letters[i]);
           backtrack(sts, list, index + 1);
           list.removeLast();
       }
   }
}
// @lc code=end

