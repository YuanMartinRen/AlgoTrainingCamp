/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */

// @lc code=start
class Solution {
    int m;
    int n;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        int x = click[0], y = click[1];
        
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        
        return board;
    }
    
    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') return;
        int mine = countMine(board, x, y);
        if (mine > 0) {
            board[x][y] = (char)(mine + '0');
        } else {
            board[x][y] = 'B';
            for (int[] dir : dirs)
                dfs(board, x + dir[0], y + dir[1]);
        }
    }
    
    private int countMine(char[][] board, int x, int y) {
        int count = 0;
        for (int[] dir : dirs) {
            int i = x + dir[0];
            int j = y + dir[1];
            if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'M')
                count++;
        }
        return count;
    }
}
// @lc code=end

