class Solution {
    int r;
    int c;
    int[][] grid;
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.r = grid.length;
        this.c = grid[0].length;

        for(int i = 0; i<r; i++)
        {
            for(int j = 0; j<c; j++)
            {
                if(grid[i][j] == 1)
                {
                    int a = dfs(i, j, new int[]{0});
                    max = Math.max(max, a);
                }
            }
        }

        return max;
    }

    private int dfs(int i, int j, int[] a)
    {
        grid[i][j] = 0;
        a[0]++;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] d : directions)
        {
            int nr = i + d[0];
            int nc = j + d[1];

            if(nr >= 0 && nr < r && nc >= 0 && nc < c && grid[nr][nc] == 1)
            {
                dfs(nr, nc, a);
            }
        }

        return a[0];
    }
}
