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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        TreeNode current=root;
        while(current!=null)
        {
            if(current.left==null)
            {
                result.add(current.val);
                current=current.right;
            }
            else{
                TreeNode pre=current.left;
                while(pre.right!=null && pre.right!=current)
                    pre=pre.right;
                if(pre.right==null)
                {
                    result.add(current.val);
                    pre.right=current;
                    current=current.left;
                }
                else{
                    pre.right = null;
                    current = current.right;
                }
            }
        }
        return result;
    }
}