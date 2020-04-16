/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 *
 * https://leetcode-cn.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (38.40%)
 * Likes:    238
 * Dislikes: 0
 * Total Accepted:    26.9K
 * Total Submissions: 61.4K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 
 * 两个相邻元素间的距离为 1 。
 * 
 * 示例 1: 
 * 输入:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * 
 * 输出:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * 
 * 示例 2: 
 * 输入:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 
 * 
 * 输出:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 
 * 
 * 注意:
 * 
 * 
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[] rx = {1, -1, 0, 0};
        int[] ry = {0, 0, 1, -1};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int k = 0; k < 4; k++) {
                int x = rx[k] + cur[0];
                int y = ry[k] + cur[1];
                    
                if(x >= 0 && y >=0 && x < m && y < n && matrix[x][y] == 1 && !visited[x][y]) {
                    res[x][y] = res[cur[0]][cur[1]] + 1;
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }

        return res;
    }
}
// @lc code=end

