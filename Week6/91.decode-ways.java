/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            int first = Integer.valueOf(s.substring(i, i + 1));
            int second = Integer.valueOf(s.substring(i - 1, i + 1));
            if (first != 0)
                dp[i] += dp[i - 1];
            if (second >= 10 && second <= 26)
                dp[i] += i >= 2 ? dp[i - 2] : i;
        }
        return dp[n - 1];
    }
}
// @lc code=end

