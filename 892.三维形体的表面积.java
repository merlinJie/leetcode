/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 *
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/description/
 *
 * algorithms
 * Easy (55.97%)
 * Likes:    100
 * Dislikes: 0
 * Total Accepted:    24.5K
 * Total Submissions: 38.2K
 * Testcase Example:  '[[2]]'
 *
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 
 * 请你返回最终形体的表面积。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[[2]]
 * 输出：10
 * 
 * 
 * 示例 2：
 * 
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 
 * 
 * 示例 3：
 * 
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 
 * 
 * 示例 4：
 * 
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 
 * 
 * 示例 5：
 * 
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * 
 * 
 */

// @lc code=start
class Solution {
    int r[] = {-1, 1, 0, 0};
    int c[] = {0, 0, -1, 1};
    int count = 0;
    public int surfaceArea(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j< grid[i].length; j++) {
                int cur = grid[i][j];
            if(cur > 0) {
                    count += 2;
                    for(int rc = 0; rc < r.length; rc++) {
                        int r1 = i + r[rc];
                        int c2 = j + c[rc];
                        if(r1 >= 0 && c2 >= 0 
                            && r1 < grid.length 
                            && c2 < grid[i].length) {
                            count += Math.max(grid[i][j] - grid[r1][c2], 0);
                        } else {
                            count += grid[i][j];
                        }
                    }
            }
        }
    }
    return count;
    }
}

// @lc code=end

