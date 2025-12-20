class Solution {
    Queue<Integer> q=new LinkedList<>();
    public void bfs(int[][] isConnected,boolean[] vis,int v)
    {
        q.add(v);
        vis[v]=true;
        while(!q.isEmpty())
        {
            int x=q.poll();
            for(int i=0;i<isConnected.length;i++)
            {
                if(isConnected[x][i]==1 && !vis[i])
                {
                    q.add(i);
                    vis[i]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n+1];
        int provinces=0;
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                provinces++;
                bfs(isConnected,vis,i);
            }
        }
        return provinces;
    }
}