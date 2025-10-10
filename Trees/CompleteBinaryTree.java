
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
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree
 * Time & Space Complexity
 * countNodes = O(n)
 * dfs = O(n)
 * Total = O(n)
 * Space = O(h) recursive stack, h = height of tree.
 * Intuition - Number nodes as if the tree were stored in an array (0-indexed): Root = 0, Left child of i = 2*i + 1, Right child of i = 2*i + 2, For a CBT, every node’s index < total number of nodes. if index > number of nodes return false
 */
class Solution {
    
    public int countNodes (TreeNode node){
        if (node ==null){
            return 0;
        }
        
        return 1 + countNodes(node.left) + countNodes (node.right);
    }
    public boolean dfs (TreeNode node, int index, int count){
        
        if (node == null) {
            return true;
        }
        
        if (index >= count){
            return false;
        }
        
        return dfs (node.left,2*index+1, count) && dfs (node.right, 2*index+2,count);
        
    }
    public boolean isCompleteTree(TreeNode root) {
        return dfs(root,0,countNodes(root));  // countNodes is executed and we get the total number of nodes before calling dfs      
    }
}
