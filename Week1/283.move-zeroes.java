/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int curr = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[curr++] = nums[i];
        }
        
        while (curr > 0 && curr < nums.length)
            nums[curr++] = 0;
    }
}
// @lc code=end

