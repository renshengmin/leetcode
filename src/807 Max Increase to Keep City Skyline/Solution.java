class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int ret = 0;
        final int m = grid.length;
        final int n = grid[0].length;
        int[] colMax = new int[n];
        int[] rowMax = new int[m];
        for(int i=0; i<m; i++) {
            int curRowMax = grid[i][0];
            for(int j=0; j<n; j++) {
                curRowMax = Math.max(curRowMax, grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
            rowMax[i] = curRowMax;
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
            	int line = Math.min(rowMax[i], colMax[j]);
                ret += line > grid[i][j] ? line - grid[i][j] : 0;
            }
        }
        return ret;
    }
}
