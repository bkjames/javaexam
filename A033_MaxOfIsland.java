package ama01;

public class A033_MaxOfIsland {

	    public static void main(String[] args) {
			
	    	int[][] grid = {
	    			         {0,0,1,0,0,0,0,1,0,0,0,0,0},
	    	                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
	    	                 {0,1,1,0,1,0,0,0,0,0,0,0,0},
	    	                 {0,1,0,0,1,1,0,0,1,0,1,0,0},
	    	                 {0,1,0,0,1,1,0,0,1,1,1,0,0},
	    	                 {0,0,0,0,0,0,0,0,0,0,1,0,0},
	    	                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
	    	                 {0,0,0,0,0,0,0,1,1,0,0,0,0}
	    	                 };
	    	A033_MaxOfIsland a = new A033_MaxOfIsland();
	    	a.maxAreaOfIsland(grid);
		}
	    
	    
	    public int maxAreaOfIsland(int[][] grid) {
	        if (grid == null || grid.length == 0) {
	            return 0;
	        }
	        int m = grid.length;
	        int n = grid[0].length;
	        int max = 0;
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (grid[i][j] == 1) {
	                    int area = dfs(grid, i, j, m, n, 0);
	                    max = Math.max(area, max);
	                }
	            }
	        }
	        return max;
	    }

	    int dfs(int[][] grid, int i, int j, int m, int n, int area) {
	        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
	            return area;
	        }
	        grid[i][j] = 0;
	        area++;
	        area = dfs(grid, i + 1, j, m, n, area);
	        area = dfs(grid, i, j + 1, m, n, area);
	        area = dfs(grid, i - 1, j, m, n, area);
	        area = dfs(grid, i, j - 1, m, n, area);
	        return area;
	    }
	    
	    
	    public int maxAreaOfIsland3(int[][] grid) {
	        int max_area = 0;
	        for(int i = 0; i < grid.length; i++)
	            for(int j = 0; j < grid[0].length; j++)
	                if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
	        return max_area;
	    }
	    
	    public int AreaOfIsland(int[][] grid, int i, int j){
	        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
	            grid[i][j] = 0;
	            return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
	        }
	        return 0;
	    }
	    
	    
	
	    int[][] grid;
	    boolean[][] seen;

	    public int area(int r, int c) {
	        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
	                seen[r][c] || grid[r][c] == 0)
	            return 0;
	        seen[r][c] = true;
	        return (1 + area(r+1, c) + area(r-1, c)
	                  + area(r, c-1) + area(r, c+1));
	    }

	    public int maxAreaOfIsland2(int[][] grid) {
	        this.grid = grid;
	        seen = new boolean[grid.length][grid[0].length];
	        int ans = 0;
	        for (int r = 0; r < grid.length; r++) {
	            for (int c = 0; c < grid[0].length; c++) {
	                ans = Math.max(ans, area(r, c));
	            }
	        }
	        return ans;
	    }
}
