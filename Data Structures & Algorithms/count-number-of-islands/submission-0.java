class Solution {
    char[][] grid;
    int r;
    int c;

    public int numIslands(char[][] grid) {
        this.r = grid.length;
        this.c = grid[0].length;
        this.grid = grid;
        int ic = 0;

        for(int i = 0; i<r; i++)
        {
            for(int j = 0; j<c; j++)
            {
                if(grid[i][j] == '1')
                {
                    ic++;
                    dfs(i, j);
                }
            }
        }

        return ic;
    }

    private void dfs(int i, int j)
    {
        grid[i][j] = '0';
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] d : directions)
        {
            int nr = d[0] + i;
            int nc = d[1] + j;

            if(nr >= 0 && nr < r && nc >= 0 && nc < c && grid[nr][nc] == '1')
            {
                dfs(nr, nc);
            }
        }
    }
}
