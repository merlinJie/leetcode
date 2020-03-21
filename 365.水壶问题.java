/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 *
 * https://leetcode-cn.com/problems/water-and-jug-problem/description/
 *
 * algorithms
 * Medium (29.87%)
 * Likes:    158
 * Dislikes: 0
 * Total Accepted:    16.5K
 * Total Submissions: 48.9K
 * Testcase Example:  '3\n5\n4'
 *
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 
 * 你允许：
 * 
 * 
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 
 * 
 * 示例 1: (From the famous "Die Hard" example)
 * 
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    Set<Map.Entry<Integer, Integer>> states = new HashSet<>();
    Queue<int[]> queue = new LinkedList<>();
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == x || z == y || z == 0) {
            return true;
        }

        if (x + y < z || x == y && x + y != z) {
            return false;
        }
        int[] temp = new int[]{0,0};
        queue.add(temp);
        AbstractMap.SimpleEntry<Integer, Integer> en = new AbstractMap.SimpleEntry(temp[0], temp[1]);
        states.add(en);
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            // System.out.print(cur[0] + " " + cur[1] + " ");
            if(cur[0] == z || cur[1] == z || cur[0] + cur[1] == z) {
                return true;
            }
            int x1 = cur[0];
            int y1 = cur[1];
            addVisited(x, y1);
            addVisited(x1, 0);

            addVisited(x1, y);
            addVisited(0, y1);

            int miny = Math.min(x1, y - y1);
            addVisited(x1 - miny, y1 + miny);

            int minx = Math.min(x - x1, y1);
            addVisited(x1 + minx, y1 - minx);

        }
        return false;
    }

    public boolean addVisited(int x, int y) {
        AbstractMap.SimpleEntry<Integer, Integer> en = new AbstractMap.SimpleEntry(x, y);
        if(states.contains(en)) {
            return true;
        } else {
            if(x >= 0 && y >= 0) {
                queue.add(new int[]{x, y});
                states.add(en);
            }
            return false;
        }
    }
}
// @lc code=end

