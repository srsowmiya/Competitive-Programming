class Solution {
    class Pair{
        int r;
        int c;
        int time;

        public Pair(int r,int c,int time)
        {
            this.r=r;
            this.c=c;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2 )
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        int t=0;
        int count=0;
        int[] row={0,0,-1,1};
        int[] col={1,-1,0,0};
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            t=Math.max(t,p.time);
            for(int i=0;i<4;i++)
            {
                int rw=p.r+row[i];
                int cl=p.c+col[i];
                if(rw>=0 && rw<m && cl>=0 && cl<n && grid[rw][cl]==1 && vis[rw][cl]!=1)
                {
                    q.add(new Pair(rw,cl,p.time+1));
                    vis[rw][cl]=1;
                    count++;
                }
            }
        }
        if(count<fresh)
            return -1;
        return t;
    }
}