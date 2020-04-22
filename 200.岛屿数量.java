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
        int[] x = {0,0,-1,1};
        int[] y = {-1,1,0,0};

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++) {
                if(grid[i][j] == '1') {
                    queue.add(new int[]{i,j});
                      while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int curR = cur[0];
                        int curC = cur[1];
                        for(int k = 0; k < 4; k++) {
                            int curX = curR + x[k];
                            int curY = curC + y[k];
                            if(curX < m && curX >=0 && curY < n && curY >= 0) {
                               if(grid[curX][curY] == '1') {
                                    grid[curX][curY] = '0';
                                    queue.add(new int[]{curX, curY});
                                }
                            }
                        }
                       
                    }
                    count += 1;
                }
            }
        }
    
      
        return count;
    }
}
// @lc code=end

