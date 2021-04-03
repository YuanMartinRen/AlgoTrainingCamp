/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int num : nums) {
            if (num > nums[i-1])
                nums[i++] = num;
        }
        return i;
    }
}
// @lc code=end

