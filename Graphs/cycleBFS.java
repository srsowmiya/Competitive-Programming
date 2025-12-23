class Solution {
    public boolean bfs(ArrayList<ArrayList<Integer>> adj,int vertex,boolean[] vis,int parent)
    {
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{vertex,parent});
        vis[vertex]=true;
        while(!q.isEmpty())
        {
            int[] arr=q.poll();
            int v=arr[0];
            int p=arr[1];
            for(int x:adj.get(v))
            {
                if(!vis[x])
                {
                    q.add(new int[]{x,v});
                    vis[x]=true;
                }
                else if(p!=x)
                    return true;
            }
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
            if(!vis[i] && bfs(adj,i,vis,-1))
                return true;
        }
        return false;
        
    }
}