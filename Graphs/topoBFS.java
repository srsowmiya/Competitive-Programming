class Solution {
    public void bfs(ArrayList<ArrayList<Integer>> adj,int[] indegree,ArrayList<Integer> result)
    {
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<indegree.length;i++)
       {
           if(indegree[i]==0)
                q.add(i);
       }
       while(!q.isEmpty())
       {
           int vertex=q.poll();
           result.add(vertex);
           for(int val:adj.get(vertex))
           {
               indegree[val]--;
               if(indegree[val]==0)
                    q.add(val);
           }
       }
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        int[] indegree=new int[V];
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        ArrayList<Integer> result=new ArrayList<>();
        bfs(adj,indegree,result);
        return result;
    }
}