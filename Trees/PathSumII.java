// https://leetcode.com/problems/path-sum-ii
/**
* remember - every add to path must have a matching remove from path in the backtracking problems
**/
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List <List<Integer>> paths = new ArrayList <>();
        if (root == null) {
            return paths;
        }
        dfs (root, 0, targetSum, new ArrayList <Integer>(), paths);
        return paths;        
    }

    public void dfs (TreeNode node, int sum, int targetSum, List<Integer> curr, List <List<Integer>> paths) {
        
        curr.add(node.val); // add the path
        int newSum = sum + node.val;

        if (node.left == null && node.right == null) {
            if (newSum == targetSum) {                
                paths.add (new ArrayList <> (curr));                                
            }   
            curr.remove(curr.size()-1);         
            return;
        }
        // explore left and right child nodes        
        if (node.left!=null) {     
            dfs (node.left, newSum, targetSum, curr, paths);
        }

        if (node.right!=null) {            
            dfs (node.right, newSum, targetSum, curr, paths);
        }
        curr.remove(curr.size()-1);
       
    }
}
