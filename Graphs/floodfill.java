class Solution {
    int[] row_x={-1,0,1,0};
    int[] col_x={0,-1,0,1};
    public void dfs(int[][] image,int r,int c,int init,int color)
    {
        image[r][c]=color;
        for(int i=0;i<4;i++)
        {
            int row=r+row_x[i];
            int col=c+col_x[i];
            if(row>=0 && row<image.length && col>=0 && col<image[0].length && image[row][col]==init)
            {
                dfs(image,row,col,init,color);
            }

        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int init=image[sr][sc];
        if(init!=color)
            dfs(image,sr,sc,init,color);
        return image;
    }
}