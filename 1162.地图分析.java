/*
 * @lc app=leetcode.cn id=1162 lang=java
 *
 * [1162] 地图分析
 *
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/description/
 *
 * algorithms
 * Medium (38.55%)
 * Likes:    92
 * Dislikes: 0
 * Total Accepted:    19.5K
 * Total Submissions: 41.7K
 * Testcase Example:  '[[1,0,1],[0,0,0],[1,0,1]]'
 *
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1
 * 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * 
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 -
 * x1| + |y0 - y1| 。
 * 
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释： 
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释： 
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * 
 * 
 */

// @lc code=start
class Solution {
    int x[] = {-1, 1, 0, 0};
    int y[] = {0, 0, 1, -1};
    public int maxDistance(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Queue<int[]> areas = new LinkedList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1) {
                    areas.offer(new int[]{i, j});
                }
            }
        }
        int[] temp = null;
        boolean has = false;
        while(!areas.isEmpty()) {
            temp = areas.poll();
            for(int i = 0; i < 4; i++) {
                int l = x[i] + temp[0];
                int l1 = y[i] + temp[1];
                if(l < 0 || l >= r || l1 < 0 || l1 >= c || grid[l][l1] != 0) {
                    continue;
                }
                grid[l][l1] = grid[temp[0]][temp[1]] + 1;
                has = true;
                areas.offer(new int[]{l, l1});
            }
        }
        if(temp == null || !has) {
            return -1;
        }
        return grid[temp[0]][temp[1]] - 1;
    }
}
// @lc code=end

