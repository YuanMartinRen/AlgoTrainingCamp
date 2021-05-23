/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1', b = (i / 3) * 3 + j / 3;
                row[i][num] = col[j][num] = box[b][num] = true;
            }
        }
        backtrack(board, 0, row, col, box);
    }
    
    private boolean backtrack(char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (n == 81) return true;
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.')
            return backtrack(board, n + 1, row, col, box);
        int b = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] || col[j][num] || box[b][num]) continue;
            board[i][j] = (char) (num + '1');
            row[i][num] = col[j][num] = box[b][num] = true;
            if (backtrack(board, n + 1, row, col, box)) return true;
            row[i][num] = col[j][num] = box[b][num] = false;
        }
        board[i][j] = '.';
        return false;
    }
}
// @lc code=end

