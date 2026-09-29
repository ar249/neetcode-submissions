class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> rotten = new ArrayDeque<>();
        int fc = 0;

        for(int i = 0; i<r; i++)
        {
            for(int j = 0; j<c; j++)
            {
                if(grid[i][j] == 1)
                {
                    fc++;
                }
                else if(grid[i][j] == 2)
                {
                    rotten.offer(new int[]{i, j});
                }
            }
        }

        if(fc == 0) return 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;

        while(!rotten.isEmpty() && fc > 0)
        {
            minutes++;
            int size = rotten.size();

            for(int i = 0; i < size; i++)
            {
                int[] idx = rotten.poll();

                for(int[] d : directions)
                {
                    int nr = d[0] + idx[0];
                    int nc = d[1] + idx[1];

                    if(nr >= 0 && nr < r && nc >= 0 && nc < c && grid[nr][nc] == 1)
                    {
                        grid[nr][nc] = 2;
                        fc--;
                        rotten.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return fc == 0 ? minutes : -1;
    }
}
