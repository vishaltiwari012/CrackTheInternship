class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int zeros = countZeros(grid);
        if(zeros != -1) return 1;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, m, n, grid, vis);
                }
            }
        }
        return count;
    }

    public static int countZeros(char[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '0') return -1;
            }
        }
        return 1;
    }

    public void dfs(int row, int col, int m, int n, char[][] grid, boolean[][] vis) {
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0' || vis[row][col]) {
            return;
        }
        vis[row][col] = true;
        if(grid[row][col] == '1') {
            dfs(row + 1, col, m, n, grid, vis);
            dfs(row - 1, col, m, n, grid, vis);
            dfs(row, col + 1, m, n, grid, vis);
            dfs(row, col - 1, m, n, grid, vis);
        }
    }
}