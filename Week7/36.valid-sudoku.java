/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!isValid(seen, number, " in row ", i) ||
                        !isValid(seen, number, " in col ", j) ||
                        !isValid(seen, number, " in block ", i/3*3 + j/3))
                        return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(Set seen, int num, String area, int region) {
        StringBuilder sb = new StringBuilder().append(num).append(area).append(region);
        return seen.add(sb.toString());
    }
}
// @lc code=end

