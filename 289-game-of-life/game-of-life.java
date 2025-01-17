class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Loop through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n);

                // Apply rules by marking the board with temporary states
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2;  // Live to Dead transition
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = -1;  // Dead to Live transition
                    }
                }
            }
        }

        // Finalize the board's next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;  // Change temporary state 2 to 0
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;  // Change temporary state -1 to 1
                }
            }
        }
    }

    // Helper function to count live neighbors
    private int countLiveNeighbors(int[][] board, int i, int j, int m, int n) {
        int liveNeighbors = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                if (board[ni][nj] == 1 || board[ni][nj] == 2) {
                    liveNeighbors++;
                }
            }
        }

        return liveNeighbors;
    }
}