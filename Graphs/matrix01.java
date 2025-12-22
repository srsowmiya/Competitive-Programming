class Solution {
    class Pair{
        int r;
        int c;
        int dist;
        public Pair(int r,int c,int dist)
        {
            this.r=r;
            this.c=c;
            this.dist=dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] vis=new int[m][n];
        int[][] distance=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int rr=p.r;
            int cc=p.c;
            int d=p.dist;
            distance[p.r][p.c]=p.dist;
            for(int i=0;i<4;i++)
            {
                int rw=rr+row[i];
                int cw=cc+col[i];
                if(rw>=0 && rw<m && cw>=0 && cw<n && vis[rw][cw]!=1 && mat[rw][cw]==1)
                {
                    q.add(new Pair(rw,cw,d+1));
                    vis[rw][cw]=1;
                }
            }

        }
        return distance;
    }
}