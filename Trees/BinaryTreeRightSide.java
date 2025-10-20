// https://leetcode.com/problems/binary-tree-right-side-view
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
    public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null) {
            return new ArrayList <Integer> ();
        }
        
        
        List <Integer> res = new ArrayList <>();
        
        
        Queue <TreeNode> bfsQ = new ArrayDeque <>();
        
        bfsQ.offer(root);
        
        while (!bfsQ.isEmpty()) {
            int qSize = bfsQ.size ();            
            List <TreeNode> levels = new ArrayList <>();
            for (int i=0; i < qSize; i++) {
                TreeNode node = bfsQ.poll();
                levels.add(node);
                if (node.left!=null) {
                    bfsQ.offer(node.left);
                }
                
                if (node.right!=null) {
                    bfsQ.offer(node.right);
                }
                
            }
            if (levels.size()!=0){
                res.add(levels.get(levels.size()-1).val);
            }
        }        
        
        return res;
    }
}
