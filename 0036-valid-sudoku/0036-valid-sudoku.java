class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Arrays to track seen numbers (1-9) for rows, columns, and 3x3 boxes
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // Skip empty cells
                if (board[r][c] == '.') {
                    continue;
                }
                
                // Convert char '1'-'9' to index 0-8
                int val = board[r][c] - '1'; 
                
                // Map the 2D row/col index to a 1D box index (0 to 8)
                int boxIndex = (r / 3) * 3 + (c / 3);
                
                // If the number has already been seen in this row, column, or box, it's invalid
                if (rows[r][val] || cols[c][val] || boxes[boxIndex][val]) {
                    return false;
                }
                
                // Mark the number as seen
                rows[r][val] = true;
                cols[c][val] = true;
                boxes[boxIndex][val] = true;
            }
        }
        
        return true;
    }
}
