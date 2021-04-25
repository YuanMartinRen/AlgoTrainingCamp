/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (s[j] >= g[i]) {
                i++;
            }
        }
        
        return i;
    }
}
// @lc code=end

