/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 *
 * https://leetcode-cn.com/problems/max-area-of-island/description/
 *
 * algorithms
 * Medium (59.74%)
 * Likes:    226
 * Dislikes: 0
 * Total Accepted:    32.8K
 * Total Submissions: 52.3K
 * Testcase Example:  '[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]'
 *
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地)
 * 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * 
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * 
 * 示例 1:
 * 
 * 
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * ⁠[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 
 * 
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * 
 * 示例 2:
 * 
 * 
 * [[0,0,0,0,0,0,0,0]]
 * 
 * 对于上面这个给定的矩阵, 返回 0。
 * 
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 * 
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cur = grid[i][j];
                if(cur == 1) {
                    int area = getArea(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int getArea(int[][] grid, int i, int j) {
        if(i == grid.length || i < 0) return 0;
        if(j == grid[0].length || j < 0) return 0;
        if(grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + getArea(grid, i + 1, j) + getArea(grid, i - 1, j) + getArea(grid, i, j + 1) + getArea(grid, i, j - 1);
        }
        return 0;
    }
}
// @lc code=end

