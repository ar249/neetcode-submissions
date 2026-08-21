class Solution {
    public boolean isValidSudoku(char[][] board) {
        
Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    // Unique string keys for row, column, and 3x3 sub-box
                    if (!seen.add(val + " in row " + i) ||
                        !seen.add(val + " in col " + j) ||
                        !seen.add(val + " in box " + (i / 3) + "-" + (j / 3))) {
                        return false;
                    }
                }
            }
        }
        return true;
        
    }

    private boolean isSqValid(char[][] square)
    {

        for(int i =0; i<square.length; i++)
        {
            if(isRowValid(i, square) == false)
            {
                return false;
            }
        }

        for(int i =0; i < square[0].length; i++)
        {
            if(isColValid(i, square) == false)
            {
                return false;
            }
        }

        return true;
    }


    private boolean isRowValid(int row, char[][] board)
    {
        Set<Character> s = new HashSet<>();
        int c = 0;
        while(c < board[0].length)
        {
            char n = board[row][c];
            if(n != '.' && s.contains(n))
            {
                return false;
            }
            else if (n != '.')
            {
                s.add(n);
            }
            c++;
        }

        return true;
    }

    private boolean isColValid(int col, char[][] board)
    {
        Set<Character> s = new HashSet<>();
        int r = 0;
        while(r < board.length)
        {
            char n = board[r][col];
            if(n != '.' && s.contains(n))
            {
                return false;
            }
            else if (n != '.')
            {
                s.add(n);
            }
            r++;;
        }

        return true;
    }
}
