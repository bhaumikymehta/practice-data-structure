package prep2024.meta.medium;

public class NumberOfIslands {
        /*
         * ["1","1","1","1","0"],
         * ["1","1","0","1","0"],
         * ["1","1","0","0","0"],
         * ["0","0","0","0","0"]
         */

        int m, n;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        public int numIslands(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(i, j, grid);
                    }
                }
            }
            return count;
        }

        public void dfs(int row, int col, char[][] matrix) {
            for (int[] direction : directions) {
                // since its a two dimention array always will be 0 and 1
                int newRowValue = row + direction[0];
                int newColumnValue = col + direction[1];
                System.out.println("New Row: " + newRowValue);
                System.out.println("New Column: " + newColumnValue);

                if (newRowValue >= 0 && newColumnValue >= 0
                        && newRowValue < m && newColumnValue < n
                        && matrix[newRowValue][newColumnValue] == '1') {
                    matrix[newRowValue][newColumnValue] = '0';
                    dfs(newRowValue, newColumnValue, matrix);
                }

            }

        }
    

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int numIslands = solution.numIslands(grid);
        System.out.println("Number of islands: " + numIslands);
    }
}