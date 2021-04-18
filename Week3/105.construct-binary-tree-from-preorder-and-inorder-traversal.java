/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder, 0, inorder.length - 1, map);
    }
    
    
    private TreeNode dfs(int[] preorder, int pStart, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {
        if (iStart > iEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pStart]);
        int index = map.get(root.val);
        root.left = dfs(preorder, pStart + 1, inorder, iStart, index - 1, map);
        root.right = dfs(preorder, pStart + index - iStart + 1, inorder, index + 1, iEnd, map);
        return root;
    }
}
// @lc code=end

