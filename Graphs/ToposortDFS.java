class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj,int[] vis,int vertex,Stack<Integer> st)
    {
        vis[vertex]=1;
        for(Integer x:adj.get(vertex))
        {
            if(vis[x]==0)
            {
                dfs(adj,vis,x,st);
            }
        }
        st.push(vertex);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
            adj.get(edges[i][0]).add(edges[i][1]);
        ArrayList<Integer> result=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int[] vis=new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
                dfs(adj,vis,i,st);
        }
        while(!st.isEmpty())
        {
            result.add(st.pop());
        }
        return result;
    }
}