/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n,k,1, result, new ArrayList<>());
        
        return result;
    }
    
    public void backtrack(int n, int k, int start, List<List<Integer>> result, List<Integer> temp){
        
        if( temp.size() == k){
                result.add(new ArrayList<>(temp));   
                return;
        }

        if( n < 0){
            return;
        }
        
        for( int i = start ; i <= n - ( k - temp.size()) + 1; i++){
            temp.add(i);
            backtrack(n , k, i + 1 , result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

