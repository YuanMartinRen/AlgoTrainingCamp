/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int left, int right, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        
        if (left < max)
            backtrack(list, str + "(", left + 1, right, max);
        if (right < left)
            backtrack(list, str + ")", left, right + 1, max);
    }
}
// @lc code=end

