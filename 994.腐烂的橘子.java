import java.util.Queue;

/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 *
 * https://leetcode-cn.com/problems/rotting-oranges/description/
 *
 * algorithms
 * Easy (46.14%)
 * Likes:    144
 * Dislikes: 0
 * Total Accepted:    16.8K
 * Total Submissions: 33.5K
 * Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 
 * 
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 
 * 
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 
 * 
 * 示例 2：
 * 
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 
 * 
 * 示例 3：
 * 
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 * 
 * 
 */

// @lc code=start
class Solution {
    
    class Node {
        int row;
        int col;
        int min;
        public Node(int row, int col, int min) {
            this.row = row;
            this.col = col;
            this.min = min;
        }
    }

    int[][] direct = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public int orangesRotting(int[][] grid) {
        int row, col, empty = 0;
        int rotten = 2;
        int fresh = 1;
        int min = 0;
        int count = 0;
        int change = 0;
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j< grid[0].length; j++) {
                if(grid[i][j] == rotten) {
                    queue.add(new Node(i, j, 0));
                } else if(grid[i][j] == fresh) {
                    count++;
                }
            }
        }
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            min = node.min;
            for(int i = 0; i < direct.length; i++) {
                int newRow = node.row + direct[i][0];
                int newCol = node.col + direct[i][1];
                if(newRow >=0 && newRow < grid.length && newCol >=0 && newCol < grid[0].length) {
                    if(grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        change++;
                        queue.add(new Node(newRow, newCol, min + 1));
                    }
                }
            }
        }
        if(count != change) {
            return -1;
        }
        return min;
    }
}
// @lc code=end

