package ama01;



import java.util.Arrays;

public class TheMaze02_cherry {

	public static void main(String[] args) {
		
		int[][] maze= {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0}
		};
		int [] start= {0,4};
		int[] dest = {4,4};
		TheMaze02_cherry a= new TheMaze02_cherry();
		System.out.println(a.shortestDistance(maze, start,dest ));
	}
	
	private static  int[][] DIRS= {{0,1},{0,-1},{-1,0},{1,0}};//right, left, top, down
	
	public int shortestDistance(int[][]maze, int[] start, int[] dest) {
		int[][] distance = new int[maze.length][maze[0].length];
		for(int[] row : distance) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		distance[start[0]][start[1]]=0;
		dfs(maze, start, distance);
		return distance[dest[0]][dest[1]] ==Integer.MAX_VALUE?-1: distance[dest[0]][dest[1]];
	}
	
	public void dfs(int[][] maze, int[] position, int[][] distance) {
		for(int[] dir:DIRS) {
			int x = position[0];
			int y = position[1];
			int count=0;
			 System.out.println("0000 x: "+x+" y: "+y);
			while(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y]==0) {
				x += dir[0];
				y += dir[1];
				count++;
			     System.out.println("aaaaa x: "+x+" y: "+y);
			}
			System.out.println();
			x-= dir[0];
			y-= dir[1];
			count--;
		    System.out.println("bbbbb x: "+x+" y: "+y+" count: "+count);
			System.out.println("before distance["+position[0]+"]"+"["+position[1]+"] "+ distance[position[0]][position[1]]+" + count "+count+" : "+(distance[position[0]][position[1]] + count )
					   +"    distance["+x+"]["+y+"] "+(distance[x][y]));
			if (distance[position[0]][position[1]] + count < distance[x][y]) {
				System.out.println("distance["+position[0]+"]"+"["+position[1]+"] "+ distance[position[0]][position[1]]+" + count "+count+" : "+(distance[position[0]][position[1]] + count )
			   +"    distance["+x+"]["+y+"] "+(distance[x][y]));
    			
           	

				
                distance[x][y] = distance[position[0]][position[1]] + count;
                System.out.println("cccc x: "+x+" y: "+y);
                dfs(maze, new int[]{x, y}, distance);
            }
		}
	}
}