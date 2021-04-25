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
        
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        
        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            Set<String> nextVisit = new HashSet<>();
            for (String word : beginSet) {
                if (checkLadder(word, endSet, visited, wordSet, nextVisit))
                    return step + 1;
            }
            
            beginSet = nextVisit;
            step++;
        }
        
        return 0;
    }
    
    private boolean checkLadder(String word, Set<String> endSet, Set<String> visited, Set<String> wordSet, Set<String> nextVisit) {
        char[] charArr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char origin = charArr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (origin == c) continue;
                charArr[i] = c;
                String target = String.valueOf(charArr);
                if (wordSet.contains(target)) {
                    if (endSet.contains(target)) {
                        return true;
                    }
                    
                    if (!visited.contains(target)) {
                        nextVisit.add(target);
                        visited.add(target);
                    }
                }
            }
            charArr[i] = origin;
        }
        return false;
    }
}
// @lc code=end

