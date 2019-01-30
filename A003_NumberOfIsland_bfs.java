package ama01;

import java.util.LinkedList;
import java.util.Queue;

public class A003_NumberOfIsland_bfs {
	
	public static void main(String[] args) {
		char[][] M  = {
				{'1','1','1','0','1'},
				{'1','1','0','0','0'},
				{'1','1','0','0','1'},
				{'0','0','0','0','1'}
		};
		A003_NumberOfIsland_bfs a = new A003_NumberOfIsland_bfs();
		System.out.println(a.numIslands(M));
		a.print(M);
	}

	 public int numIslands(char[][] grid) {
		    if (grid == null || grid.length == 0) {
		      return 0;
		    }

		    int nr = grid.length;
		    int nc = grid[0].length;
		    int num_islands = 0;

		    for (int r = 0; r < nr; ++r) {
		      for (int c = 0; c < nc; ++c) {
		        if (grid[r][c] == '1') {
		          ++num_islands;
		          grid[r][c] = '0'; // mark as visited
		          Queue<Integer> neighbors = new LinkedList<>();
		          System.out.println("val "+(r * nc + c));
		          neighbors.add(r * nc + c);
		          while (!neighbors.isEmpty()) {
		            int id = neighbors.remove();
		            int row = id / nc;
		            int col = id % nc;
		            System.out.println("row: "+row+" col: "+col);
		            if (row - 1 >= 0 && grid[row-1][col] == '1') {
		              neighbors.add((row-1) * nc + col);
		              grid[row-1][col] = '0';
		            }
		            if (row + 1 < nr && grid[row+1][col] == '1') {
		              neighbors.add((row+1) * nc + col);
		              grid[row+1][col] = '0';
		            }
		            if (col - 1 >= 0 && grid[row][col-1] == '1') {
		              neighbors.add(row * nc + col-1);
		              grid[row][col-1] = '0';
		            }
		            if (col + 1 < nc && grid[row][col+1] == '1') {
		              neighbors.add(row * nc + col+1);
		              grid[row][col+1] = '0';
		            }
		          }
		        }
		      }
		    }

		    return num_islands;
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
	
	public class Solution {
	    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	    public int numIslands(char[][] grid) {
	        if(grid==null || grid.length==0) return 0;
	        int islands = 0;
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                if(grid[i][j]=='1'){
	                    islands++;
	                    BFS(grid,i,j);
	                }
	            }
	        }
	        return islands;
	    }
	    private void BFS(char[][] grid, int x, int y){
	        grid[x][y] = '0';
	        Queue<Point> q = new LinkedList<Point>();
	        q.offer(new Point(x,y));
	        while(q.size()>0){
	            int size = q.size();
	            Point p = q.poll();
	            for(int i=0;i<size;i++){
	                for(int[] dir:dirs){
	                    int x1 = p.x+dir[0];
	                    int y1 = p.y+dir[1];
	                    if(x1>=0 && y1>=0 && x1< grid.length && y1<grid[0].length && grid[x1][y1]=='1'){
	                        grid[x1][y1] = '0';
	                        q.offer(new Point(x1,y1));
	                    }
	                }
	            }
	        }
	    }
	}
	class Point{
	    int x;
	    int y;
	    Point(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	}
	
}
