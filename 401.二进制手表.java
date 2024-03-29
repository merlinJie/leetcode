/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 *
 * https://leetcode-cn.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (51.97%)
 * Likes:    139
 * Dislikes: 0
 * Total Accepted:    14.8K
 * Total Submissions: 28.5K
 * Testcase Example:  '0'
 *
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 
 * 
 * 
 * 例如，上面的二进制手表读取 “3:25”。
 * 
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16",
 * "0:32"]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] results = new int[]{1,2,4,8,1, 2, 4, 8, 16, 32};
    List<String> listTemp = new ArrayList<>();
    List<List<Integer>> list = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        dfs(num, new LinkedList<Integer>(), 0);
        for(int i = 0; i < list.size(); i++) {
            int hour = 0;
            int mins = 0;
            for(int n : list.get(i)) {
                if(n <= 3) {
                    hour += results[n];
                } else {
                    mins += results[n];
                }
            }
            if(hour > 11 || mins > 59) {
                continue;
            }
            String time = mins < 10 ? "0" + mins : mins + "";
            listTemp.add(hour + ":" + time);
        }
        return listTemp;
    }

    public void dfs(int num, LinkedList<Integer> temp, int start) {
        if(temp.size() == num) {
            list.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i <= 9; i++) {
            temp.add(i);
            dfs(num, temp, i + 1);
            temp.removeLast();
        }
        
    }
}
// @lc code=end

