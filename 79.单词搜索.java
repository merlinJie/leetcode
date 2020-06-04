/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (41.23%)
 * Likes:    395
 * Dislikes: 0
 * Total Accepted:    53.5K
 * Total Submissions: 129.8K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 
 * 
 * 示例:
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(exit(board, dirs, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exit(char[][] bord, int[][] dirs, String word, int i, int j, int start) {
        if(start == word.length()) return true;
        if(i < 0 || j < 0 || i >= bord.length || j >= bord[0].length || bord[i][j] != word.charAt(start)) {
            return false;
        }
        char c = bord[i][j];
        bord[i][j] = '*';
        for(int[] dir: dirs) {
            int newRow = i + dir[0], newCol = j + dir[1];
            if(exit(bord, dirs, word, newRow, newCol, start + 1)) {
                return true;
            }
        }
        bord[i][j] = c;
        return false;
    }
}
// @lc code=end

