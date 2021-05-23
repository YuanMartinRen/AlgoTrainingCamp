/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] line : board)
            Arrays.fill(line, '.');
        List<List<String>> res = new ArrayList<>();
        
        backtrack(res, board, n, 0);
        
        return res;
    }
    
    private void backtrack(List<List<String>> res, char[][] board, int n, int row) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] line : board)
                temp.add(String.valueOf(line));
            res.add(temp);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (!isValid(board, n, row, col))
                continue;
            
            board[row][col] = 'Q';
            backtrack(res, board, n, row + 1);
            board[row][col] = '.';
        }
    }
    
    private boolean isValid(char[][] board, int n, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 'Q')
                return false;
        }
        
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        
        return true;
    }
}
// @lc code=end

