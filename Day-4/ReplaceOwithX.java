

//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char mat[][])
    {
        int[][] vis = new int[n][m];
        int dr[] = {-1, 0, +1, 0};
        int dc[] = {0, +1, 0, -1};
        
        for(int i = 0; i < m; i++) {
            if(vis[0][i] == 0 && mat[0][i] == 'O') {
                dfs(0, i, mat, vis, dr, dc);
            }
            
            if(vis[n - 1][i] == 0 && mat[n - 1][i] == 'O') {
                dfs(n - 1, i, mat, vis, dr, dc);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, mat, vis, dr, dc);
            }
            
            if(vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') {
                dfs(i, m-1, mat, vis, dr, dc);
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }
        
        return mat;
    }
    
    private static void dfs(int row, int col, char[][] mat, int[][] vis, int[] dr, int[] dc) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, mat, vis, dr, dc);
            }
        }
    }
}