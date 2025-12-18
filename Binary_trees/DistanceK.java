/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode nd=q.poll();
            if(nd.left!=null)
            {
                map.put(nd.left,nd);
                q.add(nd.left);
            }
            if(nd.right!=null)
            {
                map.put(nd.right,nd);
                q.add(nd.right);
            }
        }
        int dist=0;
        int x=1;
        int y=0;
        q=new LinkedList<>();
        HashMap<TreeNode,Boolean> mp=new HashMap<>();
        mp.put(target,true);
        q.add(target);
        while(!q.isEmpty() && dist<k)
        {
            while(x-->0)
            {
                TreeNode n=q.poll();

                if(n.left!=null && !mp.containsKey(n.left))
                {
                    y++;
                    q.add(n.left);
                    mp.put(n.left,true);
                }

                if(n.right!=null && !mp.containsKey(n.right))
                {
                    y++;
                    q.add(n.right);
                    mp.put(n.right,true);
                }

                if(map.get(n)!=null && !mp.containsKey(map.get(n)))
                {
                    y++;
                    q.add(map.get(n));
                    mp.put(map.get(n),true);
                }

            }
             dist++;
                x=y;
                y=0;

        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            TreeNode nd=q.poll();
            ans.add(nd.val);
        }
        return ans;
    }
}