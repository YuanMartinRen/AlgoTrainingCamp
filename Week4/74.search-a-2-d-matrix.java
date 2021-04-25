/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        
        int rows = matrix.length, cols = matrix[0].length;
        int lo = 0, hi = rows * cols - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int row = mid / cols;
            int col = mid % cols;
            
            if (matrix[row][col] == target) {
                return true;
            }
            
            if (matrix[row][col] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return false;
    }
}
// @lc code=end

