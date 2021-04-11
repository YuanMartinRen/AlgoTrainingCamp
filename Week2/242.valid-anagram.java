/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] anaTable = new int[26];
        
        for (char c : s.toCharArray()) {
            anaTable[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            if (--anaTable[c - 'a'] < 0)
                return false;
        }
        
        return true;
    }
}
// @lc code=end

