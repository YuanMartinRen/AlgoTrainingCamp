/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diffMap = new HashMap<Integer, Integer> ();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (diffMap.containsKey(diff))
                return new int[] {diffMap.get(diff), i};
            else
                diffMap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
// @lc code=end

