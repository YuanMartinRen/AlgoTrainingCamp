/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int count = 0;
        n = grid.length;
        m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void DFS(char[][] grid, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0')
            return;
        
        grid[row][col] = '0';
        DFS(grid, row + 1, col);
        DFS(grid, row, col + 1);
        DFS(grid, row - 1, col);
        DFS(grid, row, col - 1);
    }
}
// @lc code=end

