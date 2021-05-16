/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int prev = 0, result = 0;
        int[] dp = new int[cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(Math.min(prev, dp[j-1]), dp[j]) + 1;
                    result = Math.max(dp[j], result);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return result * result;
    }
}
// @lc code=end

