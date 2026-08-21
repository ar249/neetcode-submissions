class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<String>();

        for(int r = 0; r<9; r++)
        {
            for(int c = 0; c<9; c++)
            {
                char ch = board[r][c];
                int box = (r/3) * 3 + (c/3);


                if(ch != '.' && (!seen.add(ch + " in row " + r)
                   || !seen.add(ch + " in col " + c)
                   || !seen.add(ch + " in box " + box)))
                {
                    return false;
                } 
            }
        }

        return true;
    }
}
