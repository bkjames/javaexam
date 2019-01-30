package ama01;

public class A003_NumberOfIsland {
	
	public static void main(String[] args) {
		char[][] M  = {
				{'1','1','1','0','1'},
				{'1','1','0','0','0'},
				{'1','1','0','0','1'},
				{'0','0','0','0','1'}
		};
		A003_NumberOfIsland a = new A003_NumberOfIsland();
		System.out.println(a.numberOfIsland(M));
		a.print(M);
	}
	
	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	
	
	public  void merge2(char[][] grid, int i, int j) {
		int m = grid.length;
		int n = grid[0].length;
		if(i<0|| i>=m || j<0 ||j>=n || grid[i][j]!= '1' ) return;
		grid[i][j]= 'X';
		for(int[] dir: dirs)
			merge(grid, i+dir[0], j+dir[1]);
		
	}
	
	
	public  int numberOfIsland(char[][] grid) {
		if(grid==null|| grid.length==0|| grid[0].length==0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		int count =0;
		
		for(int i=0; i< m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j]== '1') {
					count++;
					merge2(grid,  i, j);
				}
			}
		}
		return count;
	}
	
	public  void merge(char[][] grid, int i, int j) {
		int m = grid.length;
		int n = grid[0].length;
		if(i<0|| i>=m || j<0 ||j>=n || grid[i][j]!= '1' ) return;
		grid[i][j]= 'X';
		merge(grid, i-1, j);
		merge(grid, i+1, j);
		merge(grid, i, j+1);
		merge(grid, i, j-1);
		
	}
	
	public static void print(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n ; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	
	

}
