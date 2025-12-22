class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0 || j==n-1 || i==0 || i==m-1)
                {
                    if(board[i][j]=='O')
                    {
                    q.add(new int[]{i,j});
                    board[i][j]='Y';
                    }
                }
            }
        }
        int row[]={-1,0,1,0};
        int col[]={0,-1,0,1};
        while(!q.isEmpty())
        {
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            for(int i=0;i<4;i++)
            {
                int rw=r+row[i];
                int cw=c+col[i];
                if(rw>=0 && rw<m && cw>=0 && cw<n && board[rw][cw]=='O' )
                {
                    q.add(new int[]{rw,cw});
                    board[rw][cw]='Y';
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='Y')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
}