/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[] mem = new int[n + 1];
        return recursive(n, n, mem);
    }
    
    public int recursive(int i, int n, int[] mem) {
        if (i < 0)
            return 0;
        if (i == 0)
            return 1;
        if (mem[i] > 0)
            return mem[i];
        mem[i] = recursive(i - 1, n, mem) + recursive(i - 2, n, mem);
        return mem[i];
    }
}
// @lc code=end

