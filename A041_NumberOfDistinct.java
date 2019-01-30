package ama01;

import java.util.HashSet;
import java.util.Set;

public class A041_NumberOfDistinct {
	
	public static void main(String[] args) {
//		int[][] grid = {
//				{1,1,0,1,1},
//				{1,0,0,0,0},
//				{0,0,0,0,1},
//				{1,1,0,1,1}
//		};
		
		int[][] grid= {
				{1,1,0,0,0},
				{1,1,0,0,0},
				{0,0,0,1,1},
				{0,0,0,1,1}
		};
		System.out.println(numDistinctIslands(grid));
	}
	
	public static int numDistinctIslands(int[][] grid) {
	    Set<String> set = new HashSet<>();
	    for(int i = 0; i < grid.length; i++) {
	        for(int j = 0; j < grid[i].length; j++) {
	            if(grid[i][j] != 0) {
	                StringBuilder sb = new StringBuilder();
	                dfs(grid, i, j, sb, "o"); // origin
	                grid[i][j] = 0;
	        
	                set.add(sb.toString());
	                System.out.println("sb: "+sb);
	                System.out.println("============");
	            }
	        }
	    }
	    System.out.println(set);
	    return set.size();
	}
	private static void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
	    if(i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0) return;
	    sb.append(dir);
	    System.out.println("dir sb: "+sb+" i "+i+" j "+j);
	    grid[i][j] = 0;
	    dfs(grid, i-1, j, sb, "u");
	    dfs(grid, i+1, j, sb, "d");
	    dfs(grid, i, j-1, sb, "l");
	    dfs(grid, i, j+1, sb, "r");
//	    sb.append("b"); // back
	    System.out.println("sb: "+sb);
	}

}
