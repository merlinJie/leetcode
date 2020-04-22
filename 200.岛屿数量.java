/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (49.05%)
 * Likes:    539
 * Dislikes: 0
 * Total Accepted:    97.8K
 * Total Submissions: 198.8K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length ==0 ) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++) {
                if(grid[i][j] == '1') {
                    count += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int curX, int curY) {
        int m = grid.length;
        int n = grid[0].length;
        if(curX >= m || curX < 0 || curY >= n || curY < 0) {
            return;
        }
        if(grid[curX][curY] == '0') {
            return;
        }
        if(grid[curX][curY] == '1') {
            grid[curX][curY] = '0';
        }
        dfs(grid, curX - 1, curY);
        dfs(grid, curX + 1, curY);
        dfs(grid, curX, curY - 1);
        dfs(grid, curX, curY + 1);
    }
}
// @lc code=end

