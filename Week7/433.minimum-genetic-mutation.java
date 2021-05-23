/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0)
            return -1;
        
        Set<String> bankSet = new HashSet<>();
        for (String s : bank)
            bankSet.add(s);
        if (!bankSet.contains(end))
            return -1;
        
        char[] gene = new char[] {'A', 'C', 'G', 'T'};
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        
        int count = 0;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (endSet.size() > startSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }
            
            Set<String> curr = new HashSet<>();
            for (String s : startSet) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (int j = 0; j < gene.length; j++) {
                        if (gene[j] == old)
                            continue;
                        arr[i] = gene[j];
                        String target = String.valueOf(arr);
                        if (endSet.contains(target))
                            return count + 1;
                        if (bankSet.contains(target))
                            curr.add(target);
                        bankSet.remove(target);
                    }
                    arr[i] = old;
                }
            }
            count++;
            startSet = curr;
        }
        return -1;
    }
}
// @lc code=end

