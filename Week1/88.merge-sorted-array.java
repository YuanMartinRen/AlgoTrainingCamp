/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        m--;
        n--;
        
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n])
                nums1[idx--] = nums1[m--];
            else
                nums1[idx--] = nums2[n--];
        }
        
        while (n >= 0)
            nums1[idx--] = nums2[n--];
    }
}
// @lc code=end

