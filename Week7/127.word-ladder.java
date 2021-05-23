/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;
        
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            Set<String> next = new HashSet<>();
            for (String word : beginSet) {
                if (checkLadder(word, endSet, wordSet, next))
                    return step + 1;
            }
            beginSet = next;
            step++;
        }
        
        return 0;
    }
    
    private boolean checkLadder(String word, Set<String> endSet, Set<String> wordSet, Set<String> next) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ori = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String target = String.valueOf(chars);
                if (endSet.contains(target))
                    return true;
                if (wordSet.contains(target)) {
                    next.add(target);
                    wordSet.remove(target);
                }
            }
            chars[i] = ori;
        }
        return false;
    }
}
// @lc code=end

