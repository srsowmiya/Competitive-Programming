class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int vertex,int parent)
    {
        vis[vertex]=true;
        for(int x:adj.get(vertex))
        {
            if(!vis[x] )
            {
            if(dfs(adj,vis,x,vertex))
                return true;
            }
            else if(x!=parent)
                return true;
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int[] edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i] && dfs(adj,vis,i,-1))
                return true;
        }
        return false;
    }
}